package e.juanluis.androidviewmodel.Model;

public class Hero {
    private String name;
    private String realname;
    private String team;
    private String firstappearance;
    private String createdby;
    private String published;
    private String imageurl;
    private String bio;

    public Hero(String name, String realname, String team, String firstappearance, String createdby, String published, String imageurl, String bio){
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.published = published;
        this.imageurl = imageurl;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }

    public String getTeam() {
        return team;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public String getCreatedby(){
        return createdby;
    }

    public String getPublished() {
        return published;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getBio() {
        return bio;
    }


}
