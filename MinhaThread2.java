import java.util.Scanner;
public class MinhaThread2 extends Thread{
    Scanner scan = new Scanner(System.in);

    private String nome;
    int tempo;

    public MinhaThread2(String nome){
        this.nome = nome;
        start();
    }

    public void run(){
        System.out.println("Qual o tempo da thread em milisegundos?");
        tempo = scan.nextInt();

        try {
            for(int i = 1; i <= 10; i++){
                System.out.println(nome + i);
                Thread.sleep(tempo);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}