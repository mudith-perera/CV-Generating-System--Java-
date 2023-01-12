import java.util.Arrays;

public class User {
    public static String[] userArr = new String[19];

    public User(String about,String workXp,String education,String mobileNo,String area ,String linkedln,String skill1,String skill2,String skill3,String lang1,String lang2,String lang3,String hobby1,String hobby2,String hobby3){
        //userArr[0]= username;
        //userArr[1]= password;
        //userArr[2]= fullName;
        userArr[3]= about;
        userArr[4]= workXp;
        userArr[5]= education;
        userArr[6]= mobileNo;
        //userArr[7]= email;
        userArr[8]= area;
        userArr[9]= linkedln;
        userArr[10]= skill1;
        userArr[11]= skill2;
        userArr[12]= skill3;
        userArr[13]= lang1;
        userArr[14]= lang2;
        userArr[15]= lang3;
        userArr[16]= hobby1;
        userArr[17]= hobby2;
        userArr[18]= hobby3;
    }
    public static void setUnamePswdFullNameEmail(String username,String pswd,String fullName,String email){
        userArr[0] = username;
        userArr[1] = pswd;
        userArr[2] = fullName;
        userArr[7] = email;
    }
    public static void setAllUserDetails(String fullName,String about,String workXp,String education,String mobileNo,String email,String area ,String linkedln,String skill1,String skill2,String skill3,String lang1,String lang2,String lang3,String hobby1,String hobby2,String hobby3){
        //userArr[0]= username;
        //userArr[1]= password;
        userArr[2]= fullName;
        userArr[3]= about;
        userArr[4]= workXp;
        userArr[5]= education;
        userArr[6]= mobileNo;
        userArr[7]= email;
        userArr[8]= area;
        userArr[9]= linkedln;
        userArr[10]= skill1;
        userArr[11]= skill2;
        userArr[12]= skill3;
        userArr[13]= lang1;
        userArr[14]= lang2;
        userArr[15]= lang3;
        userArr[16]= hobby1;
        userArr[17]= hobby2;
        userArr[18]= hobby3;
    }
    public static String[] getUserArr(){
        return userArr;
    }
    public static void printArray(){
        System.out.println(Arrays.deepToString(userArr));
    }
}
