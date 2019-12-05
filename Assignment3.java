import java.io.*;
import java.lang.Math;
class NotFoundException extends Exception{
     public String toString(){
          return "E";
     }
}
class BSTnode {
    Student s;
    String key;
    BSTnode left, right;

    public BSTnode(String key,Student s) {
       this.s = s;
       this.key=key;
       left = right = null;
    }
}
class BST {
    BSTnode root;
    int count=0;
    boolean f;
    public static String add;
    BST(){
        root = null;
    }

    int delete(String key)
    {
         int countdel;
         count=0;
         root = deletestudent(root, key);
         countdel=count;
         count=0;
         return countdel;
    }
    BSTnode deletestudent(BSTnode root, String key)
    {
         if (root == null) return root;


              if (key.compareTo(root.key)<0){
                   count++;
                   root.left = deletestudent(root.left, key);
              }
              else if (key.compareTo(root.key)>0){
                   count++;
                   root.right = deletestudent(root.right, key);
              }
              else
              {
                   count++;
                   if(root.left==null && root.right==null){
                        return null;
                   }
                   if (root.left == null){
                        count++;
                        return root.right;
                   }
                   else if (root.right == null)
                   {
                        count++;
                        return root.left;
                   }
                        root.key = minValue(root.right);
                        root.right = deletestudent(root.right, root.key);

              }

         return root;
    }
      String minValue(BSTnode root)
      {
           count--;
           String minv = root.key;
           while (root.left != null)
           {
                count++;
                minv = root.left.key;
                root = root.left;

           }
           return minv;
      }
     String address(String key){
         add="";
         root=getaddress(root,key);
         return add;
     }
     BSTnode getaddress(BSTnode root,String key){
         if(root==null){
              return null;
         }
         else{
             if(key.compareTo(root.key)==0){
                   return root;
              }
              else if(key.compareTo(root.key)<0){
                   add=add+"L";
                   root.left=getaddress(root.left,key);
              }
              else if(key.compareTo(root.key)>0){
                   add=add+"R";
                   root.right=getaddress(root.right,key);
              }
         }
         return root;
     }
    Student get(String key){
          count=0;
          //System.out.println("ROOT.key=");
          BSTnode node=getstudent(root,key);
          //System.out.println("ROOT.key="+node);
          if(node==null){
               return null;
          }
          else{
               return node.s;
          }
    }
    BSTnode getstudent(BSTnode root,String key){
         //System.out.println(".key="+root.key+"//"+key);
         if(root==null){

                  //System.out.println("W");
              return null;
         }
         if(key.compareTo(root.key)==0){
              //System.out.println("X");
              return root;
         }
         else if(key.compareTo(root.key)<0){
              //System.out.println("Y");
              return getstudent(root.left,key);
         }
         else if(key.compareTo(root.key)>0){
              //System.out.println("Z");
             return getstudent(root.right,key);
         }
         else{
              return null;
         }
    }
    boolean contains(String key){
         f=false;
         root=contains_student(root,key);
         //System.out.println(f);
         return f;
    }
    BSTnode contains_student(BSTnode root,String key){
         count++;
          //System.out.println(root);
              //System.out.println("D1");
         if(root==null){
              //System.out.println("##");
              f=false;
              return null;
         }
         else{
             //System.out.println("ROOT==>"+root.key+" / "+key);
             if(key.compareTo(root.key)==0){
               //   System.out.println("A1");
                  f=true;
                  return root;
             }
             else if(key.compareTo(root.key)<0){
                 // System.out.println("B1");
                  root.left=contains_student(root.left,key);
             }
             else if(key.compareTo(root.key)>0){
                 // System.out.println("C1");
                  root.right=contains_student(root.right,key);
             }
        }
        return root;
    }
    int update(String key,Student s){
         count=0;
         root=updatestudent(root,key,s);
         return count;
    }
    BSTnode updatestudent(BSTnode root,String key,Student s){
         count++;
         if(key.compareTo(root.key)==0){
              BSTnode left=root.left;
              BSTnode right=root.right;
              root=new BSTnode(key,s);
              root.left=left;
              root.right=right;
              return root;
         }
         else if(key.compareTo(root.key)<0){
              root.left=updatestudent(root.left,key,s);
         }
         else if(key.compareTo(root.key)>0){
              root.right=updatestudent(root.right,key,s);
         }
         return root;
    }
    int insert(String key,Student s) {
         count=0;
         root = insertstudent(root, key, s);
         return count;
    }
    BSTnode insertstudent(BSTnode root, String key,Student s) {
         count++;
        if (root == null) {
            root = new BSTnode(key,s);
            return root;
       }
        if (key.compareTo(root.key) < 0)
            root.left = insertstudent(root.left,key, s);
        else if (key.compareTo(root.key) > 0)
            root.right = insertstudent(root.right,key, s);
        return root;
    }
    void inorder()  {
       inorders(root);
       System.out.println();
    }
    void inorders(BSTnode root) {
        if (root != null) {
            inorders(root.left);
            //root.s.printdetail();
            System.out.print(root.s.fname()+"/");
            inorders(root.right);
        }
    }
}
class Pair<A,B>{
     public A fname;
     public B lname;
     public Pair(A fname,B lname){
          this.fname=fname;
          this.lname=lname;
     }
     public A fname(){
          return this.fname;
     }
     public B lname(){
          return this.lname;
     }
}
class Student implements Student_{
     public String firstname;
     public String lastname;
     public String hostelname;
     public String departmentname;
     public String cgpavalue;
     public Student(){
          firstname="";
          lastname="";
          hostelname="";
          departmentname="";
          cgpavalue="";
     }
     public Student(String firstname,String lastname,String hostelname, String departmentname,String cgpavalue){
          this.firstname=firstname;
          this.lastname=lastname;
          this.hostelname=hostelname;
          this.departmentname=departmentname;
          this.cgpavalue=cgpavalue;
     }
     public String fname(){
          return this.firstname;
     }
     public String lname(){
          return this.lastname;
     }
     public String hostel(){
          return this.hostelname;
     }
     public String department(){
          return this.departmentname;
     }
     public String cgpa(){
          return this.cgpavalue;
     }
     public void printdetail(){
          System.out.println(this.firstname+" "+this.lastname+" "+this.hostelname+" "+this.departmentname+" "+this.cgpavalue);
     }
}
class DoubleHashing<K,T> implements MyHashTable_<K,T>{
     Student arr[];
     T obj;
     K key;
     int size;
     DoubleHashing(int size){
          this.size=size;
          arr=new Student[size];
     }
     public int insert(K key, T obj){
          long index;
          //Here unchecked and unsafe operation occurs
          Pair pair=(Pair)key;
          Student student=(Student)obj;
          String fname=(String)pair.fname();
          String lname=(String)pair.lname();
          int i=0;
          do{
               index=(HashFunction.djb2(fname+lname,size)+i*HashFunction.sdbm(fname+lname,size)) % size;


               //System.out.println("INDEX OF ="+fname+" = "+index);
               i++;
               if(((arr[(int)index])!=null) && (arr[(int)index].fname().equals(""))){
                    break;
               }else if((arr[(int)index])==null){
                    break;
               }
          }while(true);
          arr[(int)index]=student;
          return i;
     }
     public int update(K key, T obj){
          Pair pair=(Pair)key;
          Student newrecord=(Student)obj;
          long index;
          String fname=(String)pair.fname();
          String lname=(String)pair.lname();
          Student temp;
          int i=0;
          if(contains(key)){
               do{
                    index=(HashFunction.djb2(fname+lname,size)+i*HashFunction.sdbm(fname+lname,size)) % size;
                    i++;
                    temp=arr[(int)index];
               }while(!(temp.fname().equals(pair.fname()) && temp.lname().equals(pair.lname())));
               arr[(int)index]=newrecord;
          }
          else{
               i=-1;
          }
          return i;

     }
     public int delete(K key){
          Pair pair=(Pair)key;
          long index;
          String fname=(String)pair.fname();
          String lname=(String)pair.lname();
          int i=0;
          Student temp;
          do{
               index=(HashFunction.djb2(fname+lname,size)+i*HashFunction.sdbm(fname+lname,size)) % size;
               i++;
               temp=arr[(int)index];
          }while(!(temp.fname().equals(pair.fname()) && temp.lname().equals(pair.lname())));
          Student deleted=new Student("","","","","");
          arr[(int)index]=deleted;
          return i;
     }
     public boolean contains(K key){
          Pair pair=(Pair)key;
          long index;
          String fname=(String)pair.fname();
          String lname=(String)pair.lname();
          boolean f=false;
          Student temp;
          for(int i=0; i<arr.length; i++){
               temp=arr[i];
               if(temp!=null){
                    if(temp.fname().equals(fname) && temp.lname().equals(lname)){
                         f=true;
                         break;
                    }
               }
          }
          return f;
     }
     public T get(K key)throws NotFoundException{
          Pair pair=(Pair)key;
          String fname=(String)pair.fname();
          String lname=(String)pair.lname();
          long index;
          long H1=HashFunction.djb2(fname+lname,size);
          long H2=HashFunction.sdbm(fname+lname,size);
          int i=0;
          Student temp=null;
          boolean f=false;
          while(arr[(int)((H1+i*H2)%size)]!=null){
               temp=arr[(int)((H1+i*H2)%size)];
               if(temp.fname().equals(fname) && temp.lname().equals(lname)){
                    f=true;
                    break;
               }
               i++;
          }
          if(f==true){
               return (T)temp;
          }
          else{
               throw new NotFoundException();
          }
     }
     public String address(K key) throws NotFoundException{
          Pair pair=(Pair)key;
          String fname=(String)pair.fname();
          String lname=(String)pair.lname();
          long index;
          long H1=HashFunction.djb2(fname+lname,size);
          long H2=HashFunction.sdbm(fname+lname,size);
          int i=0;
          Student temp;
          String address="";
          boolean f=false;
          while(arr[(int)((H1+i*H2)%size)]!=null){
               temp=arr[(int)((H1+i*H2)%size)];
               index=(H1+i*H2)%size;
               address=index+"";
               if(temp.fname().equals(fname) && temp.lname().equals(lname)){
                    f=true;
                    break;
               }
               i++;
          }
          if(f==true){
               return address;

          }
          else{
               throw new NotFoundException();
          }
     }
     public void print(){
          //System.out.println("LENGTH="+arr.length);
          for(int i=0; i<arr.length; i++){
               if(arr[i]!=null)
               System.out.println(i+"=="+arr[i].fname()+"/"+arr[i].lname()+"/"+arr[i].hostel()+"/"+arr[i].department()+"/"+arr[i].cgpa());
               else
               System.out.println("null");
          }
          //System.out.println("-----------");
     }
}
class HashFunction{
     public static long djb2(String str, int hashtableSize) {
          long hash = 5381;
          for (int i = 0; i < str.length(); i++) {
               hash = ((hash << 5) + hash) + str.charAt(i);
          }
          return Math.abs(hash) % hashtableSize;
     }
     public static long sdbm(String str, int hashtableSize) {
          long hash = 0;
          for (int i = 0; i < str.length(); i++) {
               hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash;
          }
          return Math.abs(hash) % (hashtableSize - 1) + 1;
     }
}
class SeperateChianing<K,T> implements MyHashTable_<K,T>{
     BST arr[];
     int size;
     SeperateChianing(int size){
          this.size=size;
          this.arr=new BST[size];
     }
     public int insert(K key, T obj){
          int count=0;
          String newarr[]=((String)key).split(" ");
          String k=newarr[0]+newarr[1];
          Student student=(Student)obj;
          long index=HashFunction.djb2(k,size);
          //System.out.println("INDEX ="+index);
          if(arr[(int)index]==null){
          //     System.out.println("INDEX of= "+k+" = "+index);
               arr[(int)index]=new BST();
               count=arr[(int)index].insert(k,student);
          }
          else{
          //     System.out.println("INDEX of= "+k+" = "+index);
               count=arr[(int)index].insert(k,student);
          }
          // System.out.println("ROOT=="+arr[(int)index].root.s.fname());
          return count;
     }
     public int update(K key, T obj){
          int count=0;
          String newarr[]=((String)key).split(" ");
          String k=newarr[0]+newarr[1];
          Student student=(Student)obj;
          if(contains(key)){
               long index=HashFunction.djb2(k,size);
               count=arr[(int)index].update(k,student);
          }
          else{
               count=-1;
          }
          return count;
     }
     public int delete(K key){
          int count=0;
          String newarr[]=((String)key).split(" ");
          String k=newarr[0]+newarr[1];
          long index=HashFunction.djb2(k,size);
          count=arr[(int)index].delete(k);
          return count;
     }
     public boolean contains(K key){
          boolean f=false;
          String newarr[]=((String)key).split(" ");
          String k=newarr[0]+newarr[1];
          long index=HashFunction.djb2(k,size);
          //System.out.println("A");
          if(arr[(int)index]==null){
               //System.out.println("B");
               f=false;
          }
          else{
               //System.out.println("C");
               f=arr[(int)index].contains(k);
          }
          //System.out.println("D"+false);
          return f;
     }
     public T get(K key)throws NotFoundException{
          String newarr[]=((String)key).split(" ");
          String k=newarr[0]+newarr[1];
          long index=HashFunction.djb2(k,size);
          Student stu=null;
          //System.out.println("INDEX=="+index);
          if(arr[(int)index]==null){
               //System.out.println("A");
               throw new NotFoundException();
          }
          else{
               /*System.out.println("B");
               if(arr[(int)index].get(k)==null){
                    System.out.println("C");

                    throw new NotFoundException();
               }
               else{
                    System.out.println("D");
                    stu=arr[(int)index].get(k);
               }*/
               if(contains(key)){
                    stu=arr[(int)index].get(k);
               }
               else{
                    throw new NotFoundException();
               }
          }
          return (T)stu;
     }
     public String address(K key)throws NotFoundException{
          boolean f=false;
          String newarr[]=((String)key).split(" ");
          String k=newarr[0]+newarr[1];
          String add="";
          long index=HashFunction.djb2(k,size);
          if(arr[(int)index]==null){
               throw new NotFoundException();
          }
          else{
               f=arr[(int)index].contains(k);
               add=index+"-";
               if(f==true){
                    add=add+arr[(int)index].address(k);
               }
               else{
                    throw new NotFoundException();
               }
          }
          return add;
     }
     public void print(){
          for(int i=0; i<size; i++){
               if(arr[i]==null){
                    System.out.println(i+"=null");
               }
               else{
                    System.out.print(i+" = ");
                    arr[i].inorder();
               }
          }
     }
}
public class Assignment3{
     public static void main(String args[])throws IOException{
          int size=Integer.parseInt(args[0]);
          String datastructuretype=args[1];
          String path=args[2];
          File file=new File(path);
          BufferedReader br=new BufferedReader(new FileReader(file));
          String line="";
          if(datastructuretype.equals("DH")){
               DoubleHashing d=new DoubleHashing<Pair,Student>(size);
               while((line=br.readLine())!=null){
                    String arr[]=line.split(" ");
                    if(arr[0].equals("insert")){
                         Student s=new Student(arr[1],arr[2],arr[3],arr[4],arr[5]);
                         Pair p=new Pair<String,String>(arr[1],arr[2]);
                         // System.out.println("INSERT1");
                         if(d.contains(p)){
                              System.out.println("E");
                         }
                         else{
                              System.out.println(d.insert(p,s));
                         }


                         // System.out.println("INSERT2");
                    }
                    else if(arr[0].equals("update")){
                         Student s=new Student(arr[1],arr[2],arr[3],arr[4],arr[5]);
                         Pair p=new Pair<String,String>(arr[1],arr[2]);
                         // System.out.println("UPDATE1");
                         if(d.update(p,s)==-1){
                              System.out.println("E");
                         }
                         else{
                              System.out.println(d.update(p,s));
                         }

                         // System.out.println("UPDATE2");
                    }
                    else if(arr[0].equals("delete")){
                         Pair p=new Pair<String,String>(arr[1],arr[2]);
                         // System.out.println("DELETE1");
                         if(d.contains(p)==false){
                              System.out.println("E");
                         }
                         else{
                         System.out.println(d.delete(p));}
                         // System.out.println("DELETE2");
                    }
                    else if(arr[0].equals("contains")){
                         Pair p=new Pair<String,String>(arr[1],arr[2]);
                         // System.out.println("CONTAINS1");
                         if(d.contains(p)){
                              System.out.println("T");
                         }
                         else{
                              System.out.println("F");
                         }
                         // System.out.println("CONTAINS2");
                    }
                    else if(arr[0].equals("get")){
                         Pair p=new Pair<String, String>(arr[1],arr[2]);
                         // System.out.println("GET1");
                         try{
                              Student s=(Student)d.get(p);
                              s.printdetail();
                         }
                         catch(NotFoundException e){
                              System.out.println(e);
                         }
                         // System.out.println("GET2");
                    }
                    else if(arr[0].equals("address")){
                         Pair p=new Pair<String,String>(arr[1],arr[2]);
                         //System.out.println("ADDRESS1");
                         try{
                              System.out.println(d.address(p));
                         }
                         catch(NotFoundException e){
                              System.out.println(e);
                         }
                         //System.out.println("ADDRESS2");
                    }

               }

          }
          else if(datastructuretype.equals("SCBST")){
               SeperateChianing s=new SeperateChianing<Pair,Student>(size);
               BST b=new BST();
               int o=0;
               while((line=br.readLine())!=null){
                    //System.out.println("---------------------");
                    String arr[]=line.split(" ");
                    if(arr[0].equals("insert")){
                         Student s1=new Student(arr[1],arr[2],arr[3],arr[4],arr[5]);
                         String k=arr[1]+" "+arr[2];
                         //System.out.println("INSERTING##"+(++o));
                         System.out.println(s.insert(k,s1));
                         //System.out.println("INSERTING--");
                    }
                    else if(arr[0].equals("update")){
                         Student s1=new Student(arr[1],arr[2],arr[3],arr[4],arr[5]);
                         String k=arr[1]+" "+arr[2];
                         //System.out.println("UPDATING##"+(++o));
                         if(s.contains(k)){
                              System.out.println(s.update(k,s1));;
                         }
                         else{
                              System.out.println("E");
                         }
                         //System.out.println("UPDATING--");
                    }
                    else if(arr[0].equals("delete")){
                         String k=arr[1]+" "+arr[2];
                    //     System.out.println("DELETE##"+(++o));
                         if(s.contains(k)){
                              System.out.println(s.delete(k));
                         }
                         else{
                              System.out.println("E");
                         }
                         //System.out.println("DELETE--");
                    }
                    else if(arr[0].equals("contains")){
                         String k=arr[1]+" "+arr[2];
                         //System.out.println("CONTAINS##"+(++o));
                         if(s.contains(k))
                              System.out.println("T");
                         else
                              System.out.println("F");
                         //System.out.println("CONATINS--");
                    }
                    else if(arr[0].equals("get")){
                         String k=arr[1]+" "+arr[2];
                         //System.out.println("GET##"+(++o));
                         try{
                              Student s1=(Student)s.get(k);
                              s1.printdetail();
                         }
                         catch(NotFoundException e){
                              System.out.println(e);
                         }
                         //System.out.println("GET--");
                    }
                    else if(arr[0].equals("address")){
                         String k=arr[1]+" "+arr[2];
                         //System.out.println("ADDRESS##"+(++o));
                         try{
                              String add=s.address(k);
                              System.out.println(add);
                         }
                         catch(NotFoundException e){
                              System.out.println(e);
                         }
                    }
                    //s.print();
               }
          }
     }
}
