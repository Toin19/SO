import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class File {
    private String name;
    private boolean isDirectory;

    public File(String name, boolean isDirectory) {
        this.name = name;
        this.isDirectory = isDirectory;
    }

    public String getName() {
        return name;
    }

    public boolean isDirectory() {
        return isDirectory;
    }
}

class FileSystem {
    private List<File> currentDirectory;

    public FileSystem() {
        currentDirectory = new ArrayList<>();
    }

    public void printCurrentDirectory() {
        System.out.print("Diretório atual: /");
        for (File file : currentDirectory) {
            System.out.print(file.getName() + "/");
        }
        System.out.println();
    }

    public void listFiles() {
        for (File file : currentDirectory) {
            System.out.println(file.getName());
        }
    }

    public void changeDirectory(String directoryName) {
        for (File file : currentDirectory) {
            if (file.isDirectory() && file.getName().equals(directoryName)) {
                currentDirectory.add(new File(directoryName, true));
                return;
            }
        }
        System.out.println("Diretório não encontrado: " + directoryName);
    }

    public void makeDirectory(String directoryName) {
        currentDirectory.add(new File(directoryName, true));
        System.out.println("Diretório criado: " + directoryName);
    }

    public void removeFile(String fileName) {
        for (File file : currentDirectory) {
            if (file.getName().equals(fileName)) {
                currentDirectory.remove(file);
                System.out.println("Pasta removida: " + fileName);
                return;
            }
        }
        System.out.println("Pasta não encontrada: " + fileName);
    }
}

public class FileExplorerSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileSystem fileSystem = new FileSystem();

        while (true) {
            System.out.print("Escolha o comando (pwd, ls, cd, mkdir, rm): ");
            String command = scanner.nextLine();

            switch (command) {
                case "pwd":
                    fileSystem.printCurrentDirectory();
                    break;
                case "ls":
                    fileSystem.listFiles();
                    break;
                case "cd":
                    System.out.print("Nome do diretório: ");
                    String cdDirectory = scanner.nextLine();
                    fileSystem.changeDirectory(cdDirectory);
                    break;
                case "mkdir":
                    System.out.print("Nome da pasta para criar: ");
                    String mkdirDirectory = scanner.nextLine();
                    fileSystem.makeDirectory(mkdirDirectory);
                    break;
                case "rm":
                    System.out.print("Nome da pasta pra remover: ");
                    String rmFile = scanner.nextLine();
                    fileSystem.removeFile(rmFile);
                    break;
                default:
                    System.out.println("Comando inválido");
                    break;
            }
        }
    }
}