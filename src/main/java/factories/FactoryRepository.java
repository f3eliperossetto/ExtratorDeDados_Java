package factories;

import repository.ExtractRepository;
import repository.Repository;

public final class FactoryRepository {

    private FactoryRepository(){

    }
    public static Repository buildRepository(){
      return  new ExtractRepository();
    }
}
