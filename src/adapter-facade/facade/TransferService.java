package facade;

interface TransferService {
    void transfer(Photo photo);
}

class TransferServiceImpl implements TransferService{

    @Override
    public void transfer(Photo photo) {
        System.out.println("Photo:" + photo.getContent() + " has been transferd successfully");
    }
}
