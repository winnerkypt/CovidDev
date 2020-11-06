
package scanercovid;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author nnounp
 */
public class ScanerCovid {  ////==============ตัวแปร=============

    String nameOfplace;   /////name of store
    String namePerson;    ////name for coming in store
    String[] person;     ////name of person in store now
    String[] listAllName; /////list all of name of person entered in store
    String[] numberOfTel;       ////number of telephone 

    int potiionAdd;
    int queue = 0;  ////queue for enter the shop 
    int addName = 0; /////position of list all name for add name for person
    int numberNow = 0; //number of person in store now
    double temperature = 0; //temperature of person

    
    public ScanerCovid(String nameOfpalce, int numPerson, int num, int phone) {  ///==========constructure============
        this.nameOfplace = nameOfpalce;
        person = new String[numPerson];
        listAllName = new String[num];
        this.numberOfTel = new String[phone];

    }

    public void menu() {    ////////========menu for stated===========////////

        Scanner scn = new Scanner(System.in);
        int menu;

        System.out.print("ยินดีต้อนรับเข้าสู่ " + nameOfplace
                + "\n กด 1 เพื่อลงชื่อเข้าร้าน"
                + "\n กด 2 เพื่อลงชื่อออกร้าน"
                + "\n กด 3 เพื่อเช็คคนทั้งหมดที่เข้าร้าน"
                + "\n ===จำนวนคนที่สามารถอยู๋ในร้านได้คือ " + person.length + "==="
                + "\n ===จำนวนคนในร้านตอนนี้ " + numberNow + "==="
                + "\n ===จำนวนที่คงเหลือที่สามารถเข้าร้านได้ " + (person.length-numberNow) + "==="
        );

        menu = scn.nextInt();

        switch (menu) {     ////-------------select menu----------------
            case 1:
                temp();
                break;
            case 2:
                personLeft();
                break;
            case 3:
                checkAllPerson();

                break;
            default:
                menu();

        }

    }

    public void personJoin() {     ///=================medthod for add person====================////
        Scanner scn = new Scanner(System.in);

        int LoopOfJoin = 0;
        int test = 0;

        
        while (LoopOfJoin == 0) {

            position();
            if (person[queue] != null) {
                System.out.println("***********คิวเต็ม*************");
                System.out.println("********กรุณาเลือกตำแหน่งอื่น***********");
                personJoin();
            }

            personadd();

            ///=================choose for loop or not =================== ////
            System.out.println("===พิม 0 เพื่อลงชื่อต่อ===");
            System.out.println("===พิม 1 เพื่อไปที่เมนู===");
            LoopOfJoin = scn.nextInt();

        }

        menu();

    }
    
    public void personLeft() {
        Scanner scn = new Scanner(System.in);
        int loopOfleft=0;
        while(loopOfleft==0){
            System.out.println("คนในร้านทั้งหมดตอนนี้" + Arrays.toString(person));
            System.out.println("ตำแหน่งในร้าน");
            
            potiionAdd =scn.nextInt();
            queue = potiionAdd-1;
            numPersonLeft();
            
//            potiionAdd = scn.nextInt();
//        queue = potiionAdd - 1;
            person[queue] = null;
            
            System.out.println("คนในร้านทั้งหมดตอนนี้" +Arrays.toString(person));
            System.out.println("พิมพ์ 0 เพื่อลงชื่อต่อ");
            System.out.println("พิมพ์ 1 เพื่อไปที่เมนู");
            loopOfleft = scn.nextInt();
        }
        menu();
    }
    
    public void numPersonLeft(){
        int menu = 1;
        if(person[queue]==null){
            Scanner scn = new Scanner(System.in);
            System.out.println("==ไม่มีคนให้ออก==");
            System.out.println("พิมพ์ 1 เพื่อไปที่เมนู");
            menu = scn.nextInt();
            menu();
        }
        numberNow--;
        
    }

    public void allPersonWhoJoinMyPlace() {

        listAllName[addName] = namePerson;
        addName = addName + 1;

    }

    public void temp() {

        Scanner scn = new Scanner(System.in);

        StringBuilder temp = new StringBuilder();
        System.out.println("อุณหภูมิของร่างกาย");
        temperature = scn.nextDouble();
        if (temperature >= 37.5) {

            temp.append("======================");
            temp.append("===อุณหภูมิเกินห้ามเข้า===");
            temp.append("======================");
            temp.append("===กรุณาใส่รายชื่อต่อไป===");
            System.out.println(temp.toString());
            personJoin();

        }

        personJoin();
    }

    public void personadd() {

        Scanner scn = new Scanner(System.in);

        System.out.println("ใส่ชื่อคนที่เข้าร้าน");
        namePerson = scn.next();
        person[queue] = namePerson;
        allPersonWhoJoinMyPlace();
        numberNow += 1;

        System.out.println("ใส่เบอร์โทร");
        numberOfTel[queue] = scn.next();

    }

    public void position() {

        Scanner scn = new Scanner(System.in);
        
        System.out.println("====================");
        System.out.println("คนในร้านทั้งหมดตอนนี้" + Arrays.toString(person));
        System.out.println("ตำแหน่งในร้าน");

        potiionAdd = scn.nextInt();
        queue = potiionAdd - 1;
    }

    public void checkAllPerson() {

        System.out.println(Arrays.toString(listAllName));

        for (int i = 0; i <= listAllName.length; i++) {
            System.out.println("คนที่ " + (i + 1) + " " + listAllName[i] + "," + numberOfTel[i]);

        }
    }
}
