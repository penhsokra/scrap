package camdev.sokra.khmer24.callback;

public interface InteractorResponse<T> {
    void onSuccess(T dataResponse);
    void onComplete(String message);
    void onError(String message);

}
