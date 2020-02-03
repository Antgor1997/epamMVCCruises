package Functions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IFunction {
    String execute(HttpServletRequest request, HttpServletResponse response);

}