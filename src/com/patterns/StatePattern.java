package com.patterns;

/**
 * @author Ihar Zharykau
 */
public class StatePattern {
    public static void main(String... args){
        ReadFiles readState = new ReadFiles();
        ModifyFileNames modifyFiles = new ModifyFileNames();
        FolderContext context = new FolderContext(readState);
        context.execute();
        context.setState(modifyFiles);
        context.execute();

    }
}

interface StateInterface {
    void doAction(FolderContext context);
}

class ReadFiles implements StateInterface{
    @Override
    public void doAction(FolderContext context) {
        System.out.println("read files");
    }
}

class ModifyFileNames implements StateInterface{
    @Override
    public void doAction(FolderContext context) {
        System.out.println("modify files");
    }
}

class FolderContext {

    private StateInterface state;

    public FolderContext(StateInterface state) {
        this.state = state;
    }

    public void execute() {
        state.doAction(this);
    }

    public void setState(StateInterface state) {
        this.state = state;
    }

    public StateInterface getState() {
        return state;
    }
}