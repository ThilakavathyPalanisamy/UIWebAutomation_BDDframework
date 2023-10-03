package EnumPage;

import java.time.Duration;

public enum Browsers {
    CHROME,
    FIREFOX,
    IE;
    public static Duration pageLoadTime = Duration.ofSeconds(20);
    public static Duration implicitlyWait= Duration.ofSeconds(30);

}
