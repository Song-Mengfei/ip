package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.tasklist.Task;
import duke.tasklist.TaskList;
import duke.ui.UI;



public class AddTodo extends Command {
    public AddTodo(String s) {
        super(s);
    }

    @Override
    public void execute(TaskList lst, UI io, Storage storage) throws DukeException {
        if (s.isEmpty() || s.equals(" ")) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        } else {
            Task newTask = lst.addTask(s);
            io.addTask(newTask, lst);
            storage.addToFile(newTask);
        }
    }
}
