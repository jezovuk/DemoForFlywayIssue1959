package sample;
import org.springframework.stereotype.Component;

@Component
public final class Module2 extends BaseModule {

    protected Module2() {
        super("module2", 2);
    }

}
