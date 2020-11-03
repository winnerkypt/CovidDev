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
        
        System.out.println("ยินดีต้อนรับเข้าสู่ "+nameOfplace);
        System.out.println("กด 1 เพื่อลงชื่อเข้าร้าน");
        System.out.println("กด 2 เพื่อลงชื่อออกร้าน");
        System.out.println("กด 3 เพื่อเช็คคนทั้งหมดที่เข้าร้าน");
        System.out.println("===จำนวนคนที่สามารถอยู๋ในร้านได้คือ "+person.length+"===");
        System.out.println("===จำนวนคนในร้านตอนนี้ "+numberNow+"===");
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
        
        
        ////===================วนลูปเพิ่มคนเรื่อยๆจนกว่าจะกดยกเลิก============/////////////
        while(LoopOfJoin==0){
          System.out.println("คนในร้านทั้งหมดตอนนี้"+Arrays.toString(person));
            System.out.println("ตำแหน่งในร้าน");
            
        positionOfperson=scn.nextInt();  ////////  <<<<<<<<<--------- 
        
            System.out.println("ชื่อคนที่เข้าร้าน");
        namePerson=scn.next();
        person[positionOfperson]=namePerson;
        allPersonWhoJoinMyPlace();
        numberNow+=1;
        
        
        
        
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
