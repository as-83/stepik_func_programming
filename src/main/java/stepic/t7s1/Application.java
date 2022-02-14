package stepic.t7s1;

// create Command interface and Executor class here
interface Command {
    void execute();
}

class Executor {
    void executeCommand(Command command) {
        command.execute();
    }
}

class Application {

    private final Executor executor;
    private final Editor editor;

    public Application(Executor executor, Editor editor) {
        this.executor = executor;
        this.editor = editor;
    }

    void run() {
        // write your code here
        executor.executeCommand(() -> editor.selectAll());
        executor.executeCommand(() -> editor.saveToClipboard(editor.getSelection()));
        executor.executeCommand(() -> editor.replaceSelection(editor.getSelection()));
    }
}

