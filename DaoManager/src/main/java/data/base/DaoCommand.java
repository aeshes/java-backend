package data.base;

import data.dao.DaoManager;

public interface DaoCommand {
    public Object execute(DaoManager manager);
}
