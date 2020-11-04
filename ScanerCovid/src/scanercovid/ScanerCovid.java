/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanercovid;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author nnounp
 */
public class ScanerCovid {  ////======================ตัวแปร=================
    String nameOfplace;   /////จำนวนคนในร้าน
    String namePerson;    ////ชื่อคนที่เข้าร้าน
    String [] person;     ////ชื่อของคนที่กำลังอยู่ในร้านตอนนี้
    String [] personCopy; /////รายชื่อคนทั้งหมดที่เข้าร้าน
    String [] phone;       ////เบอร์ 
    
    int positionOfperson = 0;  ////ตำแหน่งของคนที่เข้าร้านใหม่ 
    int n = 0; /////ตำแหน่งอันเลย์รายชื่อคนทั้งหมด เอาไว้แอดรายชื่อคนเข้าเรื่อยๆ
    int numberNow = 0; //จำนวนคนในร้าน ณ ตอนนี้
    

    
    
    public ScanerCovid(String nameOfpalce,int numPerson , int num ) {  ///==========คอนสตักเจอร์============
        this.nameOfplace = nameOfpalce;
        person = new String[numPerson];
        personCopy = new String[num];
        
        
    }
    
    
       
    public void menu(){    //////////////////////========เมนูตอนเริ่ม===========///////////
        
        Scanner scn=new Scanner(System.in);
        int menu;
        
//        StringBuilder welcome = new StringBuilder();
//        welcome.append("\nยินดีต้อนรับเข้าสู่ \nกด 1 เพื่อลงชื่อเข้าร้าน");
//        System.out.println(welcome.toString());
////        welcome.append("\nกด 1 เพื่อลงชื่อเข้าร้าน");
//        welcome.append("\nกด 2 เพื่อลงชื่อออกร้าน");
//        System.out.println(welcome.toString());
//        welcome.append("\nกด 3 เพื่อเช็คคนทั้งหมดที่เข้าร้าน");
//        System.out.println(welcome.toString());
//        welcome.append("\n===จำนวนคนที่สามารถอยู๋ในร้านได้คือ "+person.length+"===");
//        System.out.println(welcome.toString());
//        welcome.append("\n===จำนวนคนในร้านตอนนี้ "+numberNow+"===");
//        System.out.println(welcome.toString());
        
        System.out.print("ยินดีต้อนรับเข้าสู่ "+nameOfplace +
                "\n กด 1 เพื่อลงชื่อเข้าร้าน"+
                "\n กด 2 เพื่อลงชื่อออกร้าน"+
                "\n กด 3 เพื่อเช็คคนทั้งหมดที่เข้าร้าน"+
                "\n ===จำนวนคนที่สามารถอยู๋ในร้านได้คือ "+person.length+"==="+
                "\n ===จำนวนคนในร้านตอนนี้ "+numberNow+"==="
                );
           
        menu=scn.nextInt();
        
        
        
        switch(menu) {     ////-------------เลือกเมนู----------------
            case 1 : personJoin();
           break;
            case 2 : System.out.println("ยังไม่ได้ทำ");
            break;
            case 3 : System.out.println(Arrays.toString(personCopy)); 
            break;
          default: 
                
            
        }
        
        
    }
    
    
    
    
    
    public void personJoin(){     ///=================เม็ดตอดที่เพิ่มคนเข้าร้าน====================////
        Scanner scn=new Scanner(System.in);
        
        int LoopOfJoin = 0;
        double tem = 0;
        
        ////===================วนลูปเพิ่มคนเรื่อยๆจนกว่าจะกดยกเลิก============/////////////
        while(LoopOfJoin==0){
            
            
            StringBuilder temp = new StringBuilder();
            temp.append("อุณหภูมิของร่างกาย");
            tem=scn.nextDouble();
            if(tem>=37.5){
                
                temp.append("======================");
                temp.append("===อุณหภูมิเกินห้ามเข้า===");
                temp.append("======================");
                temp.append("===กรุณาใส่รายชื่อต่อไป===");
                System.out.println(temp.toString());
                personJoin();
                
                
                
            }
            
            
            System.out.println("====================");
          System.out.println("คนในร้านทั้งหมดตอนนี้"+Arrays.toString(person));
            System.out.println("ตำแหน่งในร้าน");
            
        positionOfperson=scn.nextInt();  ////////  <<<<<<<<<--------- 
        
            System.out.println("ใส่ชื่อคนที่เข้าร้าน");
        namePerson=scn.next();
        person[positionOfperson]=namePerson;
        allPersonWhoJoinMyPlace();
        numberNow+=1;
        
        
            System.out.println("ใส่เบอร์โทร");
            phone[positionOfperson]=scn.next();
                
        
        
        
        
        
        
        ///================= เลือกว่าจะวนลูปต่อหรือไม่ =================== ////
            System.out.println("===พิม 0 เพื่อลงชื่อต่อ===");
            System.out.println("===พิม 1 เพื่อไปที่เมนู===");
        LoopOfJoin=scn.nextInt(); 
        
        
        
        }
        
        menu();
        
    }
    
    public void allPersonWhoJoinMyPlace(){
        
        personCopy[n]=namePerson;
        n = n+1;
        
    }
    
    
    
}
