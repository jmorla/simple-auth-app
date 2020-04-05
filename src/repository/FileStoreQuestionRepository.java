package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import models.Question;

/**
 *
 * @author jmorla
 */
public class FileStoreQuestionRepository implements QuestionsRepository {

    private Properties props;
    private FileInputStream input;
    private FileOutputStream output;
    private File file;

    public FileStoreQuestionRepository() {
        file = new File("./src/questions.properties");

    }

    @Override
    public void storeQuestion(Question q) {
        try {
            prepareWrite();
            props.put(buildProperty(q, "pregunta"), q.getQustion());
            props.put(buildProperty(q, "respuesta"), q.getAnwer());

            props.store(output, "pregunta del usuario " + q.getUserId() + " para la pregunta " + q.getqNo());
        } catch (IOException ex) {
            System.err.println("Error al guardar pregunta");
        } finally {
            closeOutput();
        }

    }

    @Override
    public List<Question> findQuestionsByUserId(String id) {

        List<Question> questions = new ArrayList<>();
        try {
            prepareRead();
            props.load(input);
            for (int i = 1; i <= 3; i++) {
                var quest = new Question();
                quest.setUserId(id);
                quest.setqNo(i);
                Object q = props.getProperty(buildProperty(quest, "pregunta"));
                Object r = props.getProperty(buildProperty(quest, "respuesta"));
                if (q != null) {
                    quest.setQustion(q.toString());
                }
                if (r != null) {
                    quest.setAnwer(r.toString());
                }

                questions.add(quest);
            }

        } catch (IOException ex) {
            System.err.println("Error al leer la preguntas");
        } finally {
            closeInput();
        }

        return questions;
    }

    private String buildProperty(Question question, String type) {
        StringBuilder builder = new StringBuilder();
        builder.append(question.getUserId());
        builder.append("-");
        builder.append(question.getqNo());
        builder.append("-");
        builder.append(type);

        return builder.toString();
    }

    private void prepareRead() throws IOException {
        props = new Properties();
        input = new FileInputStream(file);
    }

    private void prepareWrite() throws IOException {
        props = new Properties();
        output = new FileOutputStream(file);
    }

    private void closeInput() {
        try {
            this.input.close();
        } catch (IOException ex) {

        }
    }

    private void closeOutput() {
        try {
            this.output.close();
        } catch (IOException ex) {

        }
    }

    public static void main(String[] args) {

        Question q = new Question("0001", "Como se llama tu universidad", "O&M", 1);

        var repository = new FileStoreQuestionRepository();
//        repository.storeQuestion(q);
        System.out.println(repository.findQuestionsByUserId("0001"));

    }

}
