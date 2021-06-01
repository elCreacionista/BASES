package BaSeDeVerDad.Metadatas;


import BaSeDeVerDad.Exceptions.NotValidDataException;

public class Date {

    int year, month, day, hour, minute, seconds;
    String full_date;

    protected Date(){
        setData(0,0,0,0,0,0);
    }
    Date(int year, int month, int day){
        setData(year, month, day, 0,0, 0);
    }
    Date(int year, int month, int day, int hour, int minute, int seconds){
        setData(year, month, day, hour, minute, seconds);
    }
    Date(String full_date) throws Throwable {
        this.full_date = full_date;
        setData(full_date);
        this.full_date = toString();
        System.out.println(toString());
        System.out.println(DayToString());
        System.out.println(minuteToString());
    }

    @Override
    public String toString() {
        return year + "/" + month + "/" + day + " " + hour + ":" + minute + ":" + seconds;
    }
    public String DayToString(){
        return year + "/" + month + "/" + day;
    }
    public String minuteToString(){
        return hour + ":" + minute + ":" + seconds;
    }

    private void setData(int year, int month, int day, int hour, int minute, int seconds){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.seconds = seconds;
    }
    private void setData(String full_date) throws Throwable {
        String[] day = new String[0], hour = new String[0];
        if (full_date.contains(" ")){
            day = full_date.split(" ")[0].split("/");
            hour = full_date.split(" ")[1].split(":");
        }
        else {
            if (full_date.contains("/")){
                day = full_date.split("/");
                hour = new String[]{"0", "0", "0"};
            }
            else if (full_date.contains(":")){
                day = new String[]{"0", "0", "0"};
                hour = full_date.split(":");

            }
        }
        if (day.length == 0 || hour.length == 0)
            throw new NotValidDataException("No hauria de sortir aquest error");

        try{

            int y = Integer.parseInt(day[0]);
            int m = Integer.parseInt(day[1]);
            int d = Integer.parseInt(day[2]);
            int h = Integer.parseInt(hour[0]);
            int mns = Integer.parseInt(hour[1]);
            int s = Integer.parseInt(hour[2]);
            setData(y,m,d,h,mns, s);


        } catch (NumberFormatException nfe){
            throw new NotValidDataException("No es una data valida, hi ha caracters errats");
        }
        catch (ArrayIndexOutOfBoundsException ar){}

    }


}
