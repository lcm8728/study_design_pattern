package facade;

interface CameraService {
    Photo takePicture(String content);
}

class CameraServiceImpl implements CameraService {

    public Photo takePicture(String content) {
        System.out.println("new picture created : " + content);
        return new Photo(content);
    }
}
