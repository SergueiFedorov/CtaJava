package Models;

import java.time.LocalDateTime;

/**
 * Created by sfedo on 10/29/2016.
 */
public abstract class ModelBase<T> {
    public LocalDateTime getUpdatedTime() {
        return UpdatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        UpdatedTime = updatedTime;
    }

    private LocalDateTime UpdatedTime;

    abstract void UpdateWith(T obj);
}
