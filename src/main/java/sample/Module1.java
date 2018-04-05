package sample;
import org.springframework.stereotype.Component;

@Component
public final class Module1 extends BaseModule {

    protected Module1() {
        super("module1", 1);
    }

}
