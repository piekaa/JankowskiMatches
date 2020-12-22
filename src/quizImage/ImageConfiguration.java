package quizImage;

public class ImageConfiguration {

    private static ImageService imageService;

    public static ImageService getImageService() {

        if (imageService == null) {
            imageService = new ImageServiceImplementation();
        }

        return imageService;

    }

}
