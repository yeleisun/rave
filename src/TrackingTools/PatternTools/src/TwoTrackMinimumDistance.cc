#include "TrackingTools/PatternTools/interface/TwoTrackMinimumDistance.h"
#include "TrackingTools/TrajectoryState/interface/TrajectoryStateOnSurface.h"
#include "TrackingTools/TrajectoryState/interface/FreeTrajectoryState.h" 
#include "FWCore/MessageLogger/interface/MessageLogger.h"
#include "FWCore/Utilities/interface/Exception.h"
#include "MagneticField/Engine/interface/MagneticField.h"

using namespace std;

namespace {
  inline GlobalPoint mean ( pair<GlobalPoint, GlobalPoint> pr ) {
    return GlobalPoint ( (pr.first.x() + pr.second.x() ) / 2. ,
        (pr.first.y() + pr.second.y() ) / 2. ,
        (pr.first.z() + pr.second.z() ) / 2. );
  }

  inline double dist ( pair<GlobalPoint, GlobalPoint> pr ) {
    return ( pr.first - pr.second ).mag();
  }
}

double TwoTrackMinimumDistance::firstAngle() const
{
  if (!status_)
    throw cms::Exception("TrackingTools/PatternTools","TwoTrackMinimumDistance::could not compute track crossing. Check status before calling this method!");
  switch ( theCharge ) {
   case (hh): return theTTMDhh.firstAngle(); break;
   case (hl): return theTTMDhl.firstAngle(); break;
   case (ll): return theTTMDll.firstAngle(); break;
  }
  return 0;
}

double TwoTrackMinimumDistance::secondAngle() const
{
  if (!status_)
    throw cms::Exception("TrackingTools/PatternTools","TwoTrackMinimumDistance::could not compute track crossing. Check status before calling this method!");
  switch ( theCharge ) {
   case (hh): return theTTMDhh.secondAngle(); break;
   case (hl): return theTTMDhl.secondAngle(); break;
   case (ll): return theTTMDll.secondAngle(); break;
  }
  return 0;
}


pair <double, double> TwoTrackMinimumDistance::pathLength() const
{
  if (!status_)
    throw cms::Exception("TrackingTools/PatternTools","TwoTrackMinimumDistance::could not compute track crossing. Check status before calling this method!");
  switch ( theCharge ) {
   case (hh): return theTTMDhh.pathLength(); break;
   case (hl): return theTTMDhl.pathLength(); break;
   case (ll): return theTTMDll.pathLength(); break;
  }
  return std::pair<double,double>(0,0);
}

pair<GlobalPoint, GlobalPoint> TwoTrackMinimumDistance::points() const
{
  if (!status_)
    throw cms::Exception("TrackingTools/PatternTools","TwoTrackMinimumDistance::could not compute track crossing. Check status before calling this method!");
  return points_;
}

bool
TwoTrackMinimumDistance::calculate(const TrajectoryStateOnSurface & sta, 
                                const TrajectoryStateOnSurface & stb) 
{
  return calculate ( sta.globalParameters(), stb.globalParameters() );
}


bool
TwoTrackMinimumDistance::calculate(const FreeTrajectoryState & sta, 
                                const FreeTrajectoryState & stb) 
{
//  pair<GlobalPoint, GlobalPoint> ret  = theIniAlgo.points ( sta, stb );
  return calculate ( sta.parameters(), stb.parameters() );
}

bool
TwoTrackMinimumDistance::calculate(const GlobalTrajectoryParameters & sta,
                                const GlobalTrajectoryParameters & stb)
{
  if ((sta.magneticField().inTesla(sta.position()).z() == 0.)|| 
  	(stb.magneticField().inTesla(stb.position()).z() == 0.)) {
    status_ = pointsLineLine(sta, stb);
  } else if ( sta.charge() != 0. && stb.charge() != 0. ) {
    status_ = pointsHelixHelix(sta, stb);
  } else if ( sta.charge() == 0. && stb.charge() == 0. ) {
    status_ = pointsLineLine(sta, stb);
  } else {
    status_ = pointsHelixLine(sta, stb);
  }
  return status_;
}

bool
TwoTrackMinimumDistance::pointsLineLine(const GlobalTrajectoryParameters & sta,
                                const GlobalTrajectoryParameters & stb)
{
  theCharge = ll;
  if (theTTMDll.calculate(sta, stb)) return false;
  points_ = theTTMDll.points();
  return true;
}

bool
TwoTrackMinimumDistance::pointsHelixLine(const GlobalTrajectoryParameters & sta,
                                const GlobalTrajectoryParameters & stb)
{
  theCharge = hl;
  if (theTTMDhl.calculate(sta, stb, 0.000001)) return false;
  points_ = theTTMDhl.points();
  return true;
}

bool
TwoTrackMinimumDistance::pointsHelixHelix(const GlobalTrajectoryParameters & sta,
                                const GlobalTrajectoryParameters & stb)
{
  if ( ( sta.position() - stb.position() ).mag() < 1e-7 &&
       ( sta.momentum() - stb.momentum() ).mag() < 1e-7 )
  {
    edm::LogWarning ( "TwoTrackMinimumDistance") << "comparing track with itself!";
  };
  theCharge = hh;
  if ( theModus == FastMode )
  {
    // first we try directly - in FastMode only ...
    if ( !(theTTMDhh.calculate ( sta, stb, .0001 )) )
    {
      points_ = theTTMDhh.points();
      return true;
    };
  };

  // okay. did not work. so we use CAIR, and then TTMD again.
  bool cairStat = theIniAlgo.calculate ( sta, stb );
  
  if (!cairStat) { // yes. CAIR may fail.
    edm::LogWarning ( "TwoTrackMinimumDistance" ) << "Computation HelixHelix::CAIR failed.";
    if ( theModus == SlowMode ) { // we can still try ttmd here.
      if ( !(theTTMDhh.calculate ( sta, stb, .0001 )) ) {
	points_ = theTTMDhh.points();
        return true;
      }
    };
    // we can try with more sloppy settings
    if ( !(theTTMDhh.calculate ( sta, stb, .1 )) ) {
	points_ = theTTMDhh.points();
        return true;
      }
    return false;
    edm::LogWarning ( "TwoTrackMinimumDistance" ) << "TwoTrackMinimumDistanceHelixHelix failed";
  };

  pair<GlobalTrajectoryParameters, GlobalTrajectoryParameters >
	ini = theIniAlgo.trajectoryParameters();

  pair<GlobalPoint, GlobalPoint> inip ( ini.first.position(), 
      ini.second.position() );
  if ( theTTMDhh.calculate ( ini.first, ini.second, .0001 ) ) {
    points_ = inip;
  } else {
    points_ = theTTMDhh.points();
    // if we are still worse than CAIR, we use CAIR results.
    if ( dist ( points_ ) > dist ( inip ) ) points_ = inip;
  };
  return true;
}


GlobalPoint TwoTrackMinimumDistance::crossingPoint() const
{
  return mean ( points_ );
}


float TwoTrackMinimumDistance::distance() const
{
  return dist ( points_ );
}
