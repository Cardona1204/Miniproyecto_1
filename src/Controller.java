import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

//VISUAL ITEMS
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller extends JFrame implements ActionListener{
    private static Scanner console = new Scanner(System.in);
    private ArrayList<Candidato> listaCandidato = new ArrayList<>();

    //GUI BANK
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;

    Container contenedor;
    public Controller (){
        initComponents();
        /* setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setVisible(true);*/

        }
    public void menu() {
        int opcion;

        do {
            mostrarMenu(); //Se realiza un metodo mostrar_Menu que tendra los print por consola para el usuario
            opcion = console.nextInt();
            console.nextLine();

            switch (opcion) {
                case 1:
                    crearCandidato();
                    break;
                case 2:
                    actualizarCandidato(candidato_index());
                    break;
                case 3:
                    eliminarCandidato(candidato_index());
                    break;
                case 4:
                    buscarCandidato();
                    break;
                case 5:
                    imprimirListaCandidatos();
                case 6:
                    menuVotos();
                    break;
                case 0:
                    System.out.println("Ha decidido salir del menu");
                    winner();
                    amount_partido();
                    cities();
                    break;
                default:
                    System.out.println("Opcion no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    // Metodo para ver las opciones del menu :D
    private  void mostrarMenu() {
        System.out.println("----- Menú -----");
        System.out.println("1. Insertar candidatos");
        System.out.println("2. Actualizar candidato");
        System.out.println("3. Eliminar candidato");
        System.out.println("4. Buscar candidato");
        System.out.println("5. Imprimir lista de candidatos");
        System.out.println("6. Menu insertar votos candidatos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private  void crearCandidato() {
        System.out.println("Ingrese el nombre del candidato: ");
        String nombre = console.nextLine();
    
        System.out.println("Ingrese el número de cédula del candidato: ");
        String cedula = console.nextLine();
    
        System.out.println("Ingrese la ciudad del candidato (Solo son válidas ciudades del departamento del Valle del Cauca)");
        String ciudad_ = console.nextLine();
        Ciudades ciudad = Ciudades.valueOf(ciudad_.toUpperCase());
    
        System.out.println("Ingrese la orientacion política de su candidato (DERECHA o IZQUIERDA)");
        String orientacion_ = console.nextLine();
        Orientacion orientacion = Orientacion.valueOf(orientacion_.toUpperCase());
    
        System.out.println("Ingrese el partido de su candidato");
        String partido_ = console.nextLine();
        Partido partido = Partido.valueOf(partido_.toUpperCase());
    

        listaCandidato.add(new Candidato(nombre, cedula, ciudad, orientacion, partido, menu_promesas()));
    }


    private ArrayList <String> menu_promesas(){ // Utilizamos un arraylist para ingresar promesas indeterminadas
        ArrayList <String> promesa = new ArrayList<String>();   // Aqui se crea un nuevo arraylist por cada candidato
        while(true){
            System.out.println("Desea agregar una promesa? \n1- SI\n2- NO");
            if(console.nextInt()!=1){
        
                break;
            } 
            console.nextLine(); //Esto limpia el buffer
            System.out.println("Ingrese la propuesta: ");
            promesa.add(console.nextLine());
        }
        return promesa; //Retorna el arraylist de promesa con todas las promesas escritas para ese candidato
    }



    public void actualizarCandidato(int indice) {
        //Validamos
        if(indice == -1)return;
        Candidato candidato = listaCandidato.get(indice);// listaCandidato.get(indice) es un candidato (n) de la arraylist
        System.out.println("Menu de actualizacion");
        listaCandidato.set(indice, menu_cambios(candidato));//el set envia informacion, entonces (posicion, menucambios) envia cambios para la posicon n del array para determinado candidato
    }

    private Candidato menu_cambios(Candidato candidato){ 
        byte eleccion;
        do {
            System.out.println("1- NOMBRE\n2- CEDULA\n3- CIUDAD\n4- ORIENTACION\n5- PARTIDO\n6- PROMESAS\n7- SALIR");
            eleccion = console.nextByte();
            console.nextLine();

            switch (eleccion) {
                case 1:
                    System.out.println("Ingrese el nuevo nombre: ");
                    candidato.setNombre(console.nextLine());//Le mandamos un nuevo nombre a la variable candidato y sera lo que el usuario escriba
                    break;
                case 2:
                    System.out.println("Ingrese la nueva cedula: ");
                    candidato.setCedula(console.nextLine());
                    break;
                case 3:
                    System.out.println("Ingrese la nueva ciudad");
                    String ciudad_ = console.nextLine();
                    Ciudades ciudad = Ciudades.valueOf(ciudad_.toUpperCase());
                    candidato.setCiudad(ciudad);
                    break;
                case 4:
                    System.out.println("Ingrese nueva orientacion (DERECHA o IZQUIERDA)");
                    String orientacion_ = console.nextLine();
                    Orientacion orientacion = Orientacion.valueOf(orientacion_.toUpperCase());
                    candidato.setOrientacion(orientacion);
                    break;
                case 5:
                    System.out.println("Ingrese el partido de su candidato");
                    String partido_ = console.nextLine();
                    Partido partido = Partido.valueOf(partido_.toUpperCase());
                    candidato.setPartido(partido);
                    break;
                case 6:
                    candidato.setPromesas(menu_promesas());
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opcion no válida. Intente nuevamente.");
                    break;
            }
        } while (eleccion != 7);

        return candidato;
    }

    private int candidato_index(){
        //VALIDAMOS
        if(listaCandidato.size()==0){
            System.out.println("No hay candidatos");
            return -1;
        }
        for (int i = 0; i < listaCandidato.size(); i++) {
            System.out.println((i + 1) + "- " + listaCandidato.get(i).getNombre());
        }

        System.out.print("Ingrese el indice del candidato que desea actualizar: ");
        short indice = console.nextShort();
        if(indice>0 && indice<= listaCandidato.size()){
            return indice-1;
        }
        return -1;
    }


    //Metodo opcion 3 eliminar candidato
    private void eliminarCandidato(int indice) {
        //VALIDAMOS
        if(indice == -1){return;}
        Candidato candidato = listaCandidato.remove(indice);
        System.out.print("Se ha eliminado el candidato " + candidato.getNombre());
    }


    //Metodo 4 buscar y mostrar candidato
    private void buscarCandidato() {
        //VALIDAMOS
        if(listaCandidato.size()==0){
            System.out.println("No hay candidatos");
            return;
        }
        System.out.print("Ingrese el nombre del candidato que desea buscar: ");
        String nombreBuscar = console.nextLine();
    
        for (Candidato candidato : listaCandidato) {//De la listaCandidato traiga cada candidato
            if (candidato.getNombre().equalsIgnoreCase(nombreBuscar)) {//y se evalua aqui
                ver_candidato(candidato);
                return; 
        }
        System.out.println("No se encontro ningún candidato con el nombre proporcionado.");

    }
}
    


    //Metodo 5 mostrar lista de candidatos

    private void imprimirListaCandidatos() {
        int contadorCandidato = 1;

        //VALIDAMOS
        if(listaCandidato.size()==0){
            System.out.println("No hay candidatos");
            return;
        }
        for (Candidato candidato : listaCandidato) {

        System.out.println("Candidato "+ contadorCandidato);
        ver_candidato(candidato);
        contadorCandidato++;
  }
            }

    public void ver_candidato(Candidato candidato){
        System.out.println("---------------------------");
        System.out.println("Nombre: " + candidato.getNombre());
        System.out.println("Cedula: " + candidato.getCedula());
        System.out.println("Ciudad: " + candidato.getCiudad());
        System.out.println("Orientación politica: " + candidato.getOrientacion());
        System.out.println("Partido politico: " + candidato.getPartido());
        System.out.println("Promesas de campaña:");
        for (String promesa : candidato.getPromesas()) {//Se trae el arraylist promesas y se guardara en el string promesa
            System.out.println(" --- " + promesa);
        }
        System.out.println("---------------------------");
    }

    //Metodo 6 menu para insertar los votos de los candidatos
    private void menuVotos()
                {
        int opcion;

        do {
            mostrarMenu2();
            opcion = console.nextInt();
            console.nextLine();

            switch (opcion) {
                case 1:
                    ingresarVotos(candidato_index());
                    break;
                case 2:
                    mostrarMenu();
                    break;
                default:
                    System.out.println("Opcion no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 2);
    }
                private  void mostrarMenu2() {
        System.out.println("----- Menú ingresar votos-----");
        System.out.println("1. Insertar votos a candidato");
        System.out.println("2. Volver al menu anterior");

    }

    private int ingresarVotos(int indice) {
        if (listaCandidato.size()==0) {
            System.out.println("No hay candidatos para ingresar votos.");
            return -1;
        }
        
        System.out.print("Ingrese el numero de votos para el candidato" + listaCandidato.get(indice).getNombre() + ": ");
        int votos = console.nextInt();
        console.nextLine();

        listaCandidato.get(indice).setVotos(votos);
        System.out.println("Numero de votos actualizado para el candidato" + listaCandidato.get(indice).getNombre() + ": " + votos);
        return votos;
    }



    private void winner(){
        ArrayList <Candidato> listaCandidato = this.listaCandidato;
        Candidato aux;
        for(int i =0; i< listaCandidato.size()-1;i++){
            for(int j=0;j<listaCandidato.size()-i-1;j++){
                Candidato next_candidato = listaCandidato.get(j+1);
                Candidato candidato_actual = listaCandidato.get(j);
                if(candidato_actual.getVotos()<next_candidato.getVotos()){
                    aux = candidato_actual;
                    listaCandidato.set(j, next_candidato);
                    listaCandidato.set(j+1, aux);
                }
                
            }
            }
            ver_candidato(listaCandidato.get(0));
        }

    private void amount_partido(){

        Map<Partido, Long> conteoPartidos = listaCandidato.stream()
                .collect(Collectors.groupingBy(Candidato::getPartido, Collectors.counting()));

        Optional<Map.Entry<Partido, Long>> partidoConMasCandidatos = conteoPartidos.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        partidoConMasCandidatos.ifPresent(entry -> {
            Partido partido = entry.getKey();
            long candidatosEnPartido = entry.getValue();
            System.out.println("El partido con más candidatos es: " + partido + " con " + candidatosEnPartido + " candidatos.");
        });

        if (!partidoConMasCandidatos.isPresent()) {
            System.out.println("No se encontraron candidatos.");
        }
    }

    public void cities (){
        Map<Ciudades, Long> conteoCiudades = listaCandidato.stream()
                .collect(Collectors.groupingBy(Candidato::getCiudad, Collectors.counting()));

        List<Map.Entry<Ciudades, Long>> ciudadesConMenosCandidatos = conteoCiudades.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Top 3 de ciudades con menos candidatos:");
        ciudadesConMenosCandidatos.forEach(entry -> {
            Ciudades ciudad = entry.getKey();
            long candidatosInscritos = entry.getValue();
            System.out.println(ciudad + ": " + candidatosInscritos + " candidatos");
        });
      
    }

    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(211, 243, 238));

        jLabel3.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Por favor ingrese la opción de su preferencia");
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("1 - Insertar Candidato");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("2 - Actualizar Candidato");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("3 - Eliminar Candidato");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("5 - Listar Candidatos");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel8.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("4 - Buscar Candidato por nombre");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextField1.setToolTipText("");

        jButton1.setText("Enter");
        jButton1.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(183, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(210, 210, 210))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
        );

        pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton1){    //getsource contiene el objeto en donde se origino el evento
            try {
                switch (jTextField1.getText()) {
                    case "1":
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        break;
                    case "5":
                        break;
                    default:
                        break;
                }
            } catch (Exception ex) {
                // TODO: handle exception
            }
            
            System.exit(0); //Cierra la interfaz grafica
        }
    }


        public static void main(String args[]) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
    
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Controller().setVisible(true);
                }
            });
        }
    }