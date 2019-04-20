import Model.Post;
import Model.User;
import Utils.Funcions;
import Utils.Importador;


public class Main {

    public static Importador importer = new Importador();
    private static Funcions funcio = new Funcions(importer);


    public static void main(String[] args) {
        int menuInicial;
        boolean exit = false;
        Menu menu = new Menu();
        int op;

        while (!exit) {
            menuInicial = menu.MenuInicial();

            switch (menuInicial) {
                case 1:
                    int importacio = menu.MenuImportacio();
                    String importRoute = menu.RutaFitxer();
                    switchImportacio(importacio, importRoute, menu);

                    break;

                case 2:
                    int exportacio = menu.MenuExportacio();
                    String exportRoute = menu.RutaFitxer();
                    switchExportacio(exportacio, exportRoute);

                    menu.printaCarregantInfo();
                    long initTime1 = System.currentTimeMillis();

                    //Mirem si existeix fitxer i importem, posem exported a true
                    boolean exported = false;//retornara true si no hi ha cap error
                    int elements1 = 0;        //size del arraylist de elements
                    if (exported) {
                        long time = System.currentTimeMillis() - initTime1;
                        menu.printaExportatExit(elements1, (int) time);
                    } else {
                        System.out.println("Error al exportar");
                    }
                    break;

                case 3:
                    int visualitzacio = menu.MenuVisualitzacio();
                    switchVisualitzacio(visualitzacio);
                    break;

                case 4:
                    op = menu.MenuBasic();
                    int insercio = menu.printaMenuInsercio();
                    switchInsercio(insercio, op);
                    break;

                case 5:
                    op = menu.MenuBasic();
                    int eliminacio = menu.printaMenuEliminacio();
                    switchEliminacio(eliminacio, op);
                    break;

                case 6:
                    op = menu.MenuBasic();
                    int cerca = menu.printaMenuCerca();
                    switchCerca(cerca, op);
                    break;

                case 7:
                    menu.configAutocompletar();
                    break;

                default:
                    exit = true;
                    break;

            }
        }
    }


    private static void switchImportacio(int opcio, String importRoute, Menu menu) {
        long initTime = System.currentTimeMillis();
        int elements = 0;                                                                                                       //  Nombre de elements importats

        switch (opcio) {
            case 1:
                break;

            case 2:
                break;

            case 3:
                elements = importer.AVLImporter(importRoute);
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;

            default:
                System.out.println("Error de opcio! (SwitchImportacio)");
                break;

        }

        menu.printaCarregantInfo();
        boolean imported = elements != -1;                                                                                      // Si retorna -1 elements, vol dir que no s'ha importat

        if (imported) {
            long time = System.currentTimeMillis() - initTime;
            menu.printaImportatExit(elements, (int) time);
        } else {
            System.out.println("Error al importar");
        }

    }

    private static void switchExportacio(int opcio, String exportRoute) {
        switch (opcio) {
            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;

            default:
                System.out.println("Error de opcio! (SwitchExportacio)");
                break;

        }
    }

    private static void switchVisualitzacio(int opcio) {
        switch (opcio) {
            case 1:
                break;

            case 2:
                break;

            case 3:
                importer.tree.inOrder(importer.tree.root, 0);
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;

            default:
                System.out.println("Error de opcio! (SwitchVisualitzacio)");
                break;

        }
    }

    private static void switchInsercio(int insercio, int opcio) {
        switch (insercio) {
            case 1:
                User user = funcio.insercioUser(opcio);
                if (user != null) {
                    switch (opcio) {
                        case 1:
                            break;

                        case 2:
                            break;

                        case 3:
                            importer.tree.addElement(user.getUsername().hashCode(), user, user.getUsername());
                            break;

                        case 4:
                            break;

                        case 5:
                            break;

                        case 6:
                            break;
                    }
                }
                break;

            case 2:
                Post post = funcio.insercioPost(opcio);
                if (post != null) {
                    switch (opcio) {
                        case 1:
                            break;

                        case 2:
                            break;

                        case 3:
                            //importer.tree.addElement(post.getUsername().hashCode(), user, user.getUsername());    // cal completar,a fegir a quin arbre?----------------
                            break;

                        case 4:
                            break;

                        case 5:
                            break;

                        case 6:
                            break;
                    }
                }
                break;

            default:
                System.out.println("Error de opcio! (SwitchInsercio)");
                break;

        }
    }

    private static void switchEliminacio(int eliminacio, int opcio) {
        switch (eliminacio) {
            case 1:
                funcio.eliminacioUser(opcio);
                break;

            case 2:
                funcio.eliminacioPost(opcio);
                break;

            default:
                System.out.println("Error de opcio! (SwitchEliminacio)");
                break;

        }
    }

    private static void switchCerca(int cerca, int opcio) {
        switch (cerca) {
            case 1:
                funcio.cercaUser(true, opcio);
                break;

            case 2:
                funcio.cercaPost(opcio);
                break;

            case 3:
                funcio.cercaHashtag(opcio);
                break;

            case 4:
                funcio.cercaUbicacio(opcio);
                break;

            case 5:
                funcio.cercaPersonalitzada(opcio);
                break;

            default:
                System.out.println("Error de opcio! (SwitchCerca)  Opcio:" + cerca);
                break;
        }

    }

}
