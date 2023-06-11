package pojo;

import java.sql.Date;

public class Player {
	private int id;
	private String playername;
	private Date dob;
	private int wickets;
	private double batting_avg;
	private int teamid;
	public Player(int id, String playername, Date dob, int wickets, double batting_avg, int teamid) {
		super();
		this.id = id;
		this.playername = playername;
		this.dob = dob;
		this.wickets = wickets;
		this.batting_avg = batting_avg;
		this.teamid = teamid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlayername() {
		return playername;
	}
	public void setPlayername(String playername) {
		this.playername = playername;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public double getBatting_avg() {
		return batting_avg;
	}
	public void setBatting_avg(double batting_avg) {
		this.batting_avg = batting_avg;
	}
	public int getTeamid() {
		return teamid;
	}
	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}
	@Override
	public String toString() {
		return "Player [id=" + id + ", playername=" + playername + ", dob=" + dob + ", wickets=" + wickets
				+ ", batting_avg=" + batting_avg + ", teamid=" + teamid + "]";
	}
	

}
