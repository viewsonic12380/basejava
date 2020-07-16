package exception;

public class NonExistStorageException extends StorageException{
    public NonExistStorageException(String uuid) {
        super("Resume "+uuid+" not exist",uuid);
    }
}
