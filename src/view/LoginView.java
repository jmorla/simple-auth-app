package view;

import static java.lang.System.out;
import java.util.Scanner;
import models.Question;
import repository.FileStoreQuestionRepository;
import repository.QuestionsRepository;

public class LoginView {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        QuestionsRepository repository = new FileStoreQuestionRepository();

        out.println("-------------------------------------------------------------------\n"
                + "=================App Empresa Software International================\n"
                + "-------------------------------------------------------------------\n"
                + "Menu de obciones (n)\n"
                + "\n"
                + "1............................................Para crear un usuario\n"
                + "2............................................Logearme en el sistema\n"
                + "3............................................Salir del sistema");

        int op = scanner.nextInt();
        scanner.nextLine();
        switch (op) {
            case 1:
                out.println("Inserte su id de usuario: ");
                String userId = scanner.nextLine();
                createUser(userId, scanner, repository);
                break;

        }
    }

    private static void createUser(String userId, Scanner scanner, QuestionsRepository repository) {

        out.println("A continuacion le pediremos 3 preguntas de seguridad");

        for (int i = 1; i <= 3; i++) {
            System.out.print("Pregunta " + i + ": ");
            String pregunta = scanner.nextLine();

            System.out.print("Respuesta " + i + ": ");
            String respuesta = scanner.nextLine();

            repository.storeQuestion(new Question(userId, pregunta, respuesta, i));
        }
    }
}
