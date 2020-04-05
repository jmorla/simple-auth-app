
package repository;

import java.util.List;
import models.Question;

/**
 *
 * @author jmorla
 */
public interface QuestionsRepository {
    
    
    void storeQuestion(Question q);
    
    List<Question> findQuestionsByUserId(String id);
    
}
