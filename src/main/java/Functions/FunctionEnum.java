package Functions;

public enum  FunctionEnum {
    LOGIN{
        {
            this.function=new LoginFunction();
        }
    },
    LOGOUT{
        {
            this.function=new LogoutFunction();
        }
    };
    IFunction function;
    public IFunction getCurrentFunction(){
        return function;
    }
}
