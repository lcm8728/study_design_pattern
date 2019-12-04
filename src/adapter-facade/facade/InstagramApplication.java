package facade;

public class InstagramApplication {
    private CameraService cameraService;
    private SuggestService suggestService;
    private TransferService transferService;

    public InstagramApplication(CameraService cameraService, SuggestService suggestService, TransferService transferService) {
        this.cameraService = cameraService;
        this.suggestService = suggestService;
        this.transferService = transferService;
    }

    public void post(String type) {
        Photo photo = cameraService.takePicture(type);
        suggestService.suggest(photo);
        transferService.transfer(photo);
        System.out.println();
    }
}
