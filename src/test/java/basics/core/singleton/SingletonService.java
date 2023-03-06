package basics.core.singleton;

public class SingletonService {

    //싱글톤 패턴의 단점 -> 코드를 다 작성해야 됨

    /*static :
        - 스태틱 메서드 안에서는 객체변수 접근이 불가능 하다.

        싱글톤 패턴 -> 싱글톤은 단 하나의 객체만을 생성하게 강제하는 패턴이다.
        즉 클래스를 통해 생성할 수 있는 객체는 Only One, 즉 한 개만 되도록 만드는 것이 싱글톤이다.
    */
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        //static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.
        //이 객체 인스턴스가 필요하면 오직 `getInstance()` 메서드를 통해서만 조회할 수 있다.
        /*딱 1개의 객체 인스턴스만 존재해야하므로, 생성자를 private으로 막아서 혹시라도 외부에서 new
            키워드로 객체 인스턴스가 생성되는 것을 막는다.
        */
        return instance;
    }

    public SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 로직을 호출했다.");
    }

}
