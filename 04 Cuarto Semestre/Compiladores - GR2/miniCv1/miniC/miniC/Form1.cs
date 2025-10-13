using MiniC;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace miniC
{
    public partial class frmEditor : Form
    {
        String Archivo;     // Define a global variable 
        public frmEditor()
        {
            InitializeComponent();
        }

        private void OpcNuevo_Click(object sender, EventArgs e)
        {
            rtbEditor.Clear(); // Clear the text box
            Archivo = null; // Reset the file name
            frmEditor.ActiveForm.Text = "Mini C"; // Set the form title to "Nuevo"
        }

        private void OpcAbrir_Click(object sender, EventArgs e)
        {
            OpenFileDialog AbrirArchivo = new OpenFileDialog(); // Create a new OpenFileDialog instance
            AbrirArchivo.Filter = "Mini C | *.c"; // Set the filter for file types
            if(AbrirArchivo.ShowDialog()== DialogResult.OK) // Show the dialog and check if the user clicked OK
            {
                Archivo = AbrirArchivo.FileName; // Get the file name
                using (StreamReader sr = new StreamReader(Archivo)) // Create a StreamReader to read the file
                {
                    rtbEditor.Text = sr.ReadToEnd(); // Read the entire file and set it as the text of the text box
                }
                frmEditor.ActiveForm.Text = "Mini C - " + Archivo; // Set the form title to "Mini C - [file name]"
            }
        }

        private void OpcGuardar_Click(object sender, EventArgs e)
        {
            SaveFileDialog GuardarArchivo = new SaveFileDialog(); // crear cuadro dialog guardar archivo
            GuardarArchivo.Filter = "MiniC | *.c"; // filtrar solo los archivos .c
            if (Archivo != null) // si variable global archivo esta vacia 
            {
                using (StreamWriter sw = new StreamWriter(Archivo))
                {
                    sw.Write(rtbEditor.Text); // guardar lo que esté en el rtbEditor
                }
            }
            else
            {
                if (GuardarArchivo.ShowDialog() == DialogResult.OK) // si hubo un archivo previamente abierto al que quiero guardar
                {
                    Archivo = GuardarArchivo.FileName; // conservamos elnombre del archivo
                    using (StreamWriter sw = new StreamWriter(GuardarArchivo.FileName))
                    {
                        sw.Write(rtbEditor.Text); // guardar lo que esté en el rtbEditor
                    }
                }
            }
        }

        private void OpcGuardarComo_Click(object sender, EventArgs e)
        {
            SaveFileDialog GuardarComo = new SaveFileDialog() // abrir cuadro de dialogo guardar como
            {
                Title = "Guardar como: ",
                Filter = "MiniC | *.c",
                AddExtension = true
            }; // colocamos las propiedades del cuadro de diálogo
            GuardarComo.ShowDialog(); // creamos el cuadro de diálogo
            if (Archivo != null && GuardarComo.FileName != String.Empty) // forzamos a que nos de el nombrede archivo
            {
                Archivo = GuardarComo.FileName; // colocamos el nuevo nombre en la variable archivo
                using (StreamWriter sw = new StreamWriter(GuardarComo.FileName))
                {
                    sw.Write(rtbEditor.Text); // guardar lo que está en el editor
                    frmEditor.ActiveForm.Text = "MiniC | " + Archivo; // colocamos el nuevo nombre de archivo en la ventana
                    sw.Close();
                }
            }
        }

        private void OpcSalir_Click(object sender, EventArgs e)
        {
            this.Dispose();// destruimos el formulario
        }

        private void compilarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            AnalizarLexico AL = new AnalizarLexico(); // creamos un objeto de nuestro analizador lexico
            List<string> LstTokens = AL.AnalisisLexico(rtbEditor.Text); // Le pasamos el archivo para crear una lista de tokens

            LstTokens.Insert(0, "\n"); // agregamos un salto de linea para que no quede junto

            foreach (string s in LstTokens) // agregamos la información recibida el rtbeditor
            {
                rtbEditor.Text += s + '\n';
            }
        }
    }
}
