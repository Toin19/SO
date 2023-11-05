public class MinhaThread extends Thread{

    
     private String nome;
     
     public MinhaThread(String nome){
        this.nome = nome;   
     }
     
     
     public void run(){
      
       try {
           for(int i = 1; i <= 10; i++){
               System.out.println(nome + i );
            
            }
        } catch (Exception e) {
            // TODO: handle exception
            

        }

    }
    
}


    

