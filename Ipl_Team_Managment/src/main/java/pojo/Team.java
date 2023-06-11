package pojo;

public class Team {
private int teamid;
private String tname;

public Team(int teamid, String tname) {
	super();
	this.teamid = teamid;
	this.tname = tname;

}
public int getTeamid() {
	return teamid;
}
public void setTeamid(int teamid) {
	this.teamid = teamid;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}


@Override
public String toString() {
	return "Team [teamid=" + teamid + ", tname=" + tname + "]";
}



}
