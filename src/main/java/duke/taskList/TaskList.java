package duke.taskList;

import duke.exception.DukeException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class TaskList extends ArrayList<Task> {

    public TaskList(Collection<Task> load) {
        super(load);
    }

    public TaskList() {
        super();
    }

    public Task addTask(String name) {
        Task t = Task.of(name);
        add(t);
        return t;
    }

    public Task addTask(String name, LocalDate d) {
        Task t = Task.of(name, d);
        add(t);
        return t;
    }

    public Task addTask(String name, LocalDate dFrom, LocalDate dTo) {
        Task t = Task.of(name, dFrom, dTo);
        add(t);
        return t;
    }

    public Task mark(int index) throws DukeException {
        try {
            Task t = get(index - 1);
            if (t.mark()) {
                return t;
            }else {
                throw new DukeException("OOPS!!! This task has already be marked!\n");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("OOPS!!! There is no such a task\n");
        }
    }

    public Task unmark(int index) throws DukeException {
        try {
            Task t = get(index - 1);
            if (t.unmark()) {
                return t;
            }else {
                throw new DukeException("OOPS!!! This task hasn't be marked yet!\n");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("OOPS!!! There is no such a task\n");
        }
    }

    public Task delete(int index) throws DukeException {
        try {
            Task t = get(index - 1);
            remove(index - 1);
            return t;
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("OOPS!!! There is no such a task\n");
        }
    }

    /**
     * Searches the task list for tasks that match the given search query.
     *
     * @param s The search query to match against task names.
     * @return An ArrayList containing tasks that match the search query.
     */
    public ArrayList<Task> find(String s) {
        ArrayList<Task> res = new ArrayList<>();
        forEach(x -> {
            if (x.isMatch(s)) {
                res.add(x);
            }
        });
        return res;
    }
}
