/*
 * Copyright 2017 José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.forms;

import java.awt.Image;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.japo.java.components.BackgroundPanel;
import org.japo.java.lib.UtilesApp;
import org.japo.java.lib.UtilesSwing;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class GUI extends JFrame {

    // Propiedades APP
    private Properties prpApp;

    // Constructor
    public GUI() {
        // Inicializar GUI - PREVIA
        beforeInit();

        // Construcción - GUI
        initComponents();

        // Inicializar GUI - POSTERIOR
        afterInit();
    }

    // Inicializar GUI - PREVIA
    private void beforeInit() {
        // Restaurar Estado Previo
        restaurarEstado();

        // Valida Instancia Única
        supervisarEjecucion();
    }

    // Inicializar GUI - POSTERIOR
    private void afterInit() {
        // Otras inicializaciones
    }

    // Construcción - GUI
    private void initComponents() {
        // Otros componentes

        // Fondo Ventana - Recurso
        URL urlFRM = getClass().getResource("/img/background.jpg");
        Image imgFRM = new ImageIcon(urlFRM).getImage();

        // Panel Principal
        JPanel pnlPpal = new BackgroundPanel(imgFRM);

        // Icono Ventana - Recurso
        URL urlICN = getClass().getResource("/img/favicon.png");
        Image imgICN = new ImageIcon(urlICN).getImage();

        // Ventana principal
        setTitle("Java App Template");
        setContentPane(pnlPpal);
        setResizable(false);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setIconImage(imgICN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Gestion Ejecución única
    private void supervisarEjecucion() {
        if (UtilesApp.activarInstancia(prpApp)) {
            // Primera Instancia - Continuar
        } else {
            // Segunda Instancia - Terminar
            UtilesSwing.terminarPrograma(this);
        }
    }

    public void procesarCerrarVentana(WindowEvent e) {
        // Memorizar Estado Actual
        memorizarEstado();
    }

    private void memorizarEstado() {
        // Memoriza Estado Actual

        // Guardar Estado Actual
        UtilesApp.guardarPropiedades(prpApp);
    }

    private void restaurarEstado() {
        // Carga Propiedades App
        prpApp = UtilesApp.cargarPropiedades();

        // Restaura Estado Previo
    }
}
