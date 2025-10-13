namespace miniC
{
    partial class frmEditor
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.archivoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.OpcNuevo = new System.Windows.Forms.ToolStripMenuItem();
            this.OpcAbrir = new System.Windows.Forms.ToolStripMenuItem();
            this.OpcGuardar = new System.Windows.Forms.ToolStripMenuItem();
            this.OpcGuardarComo = new System.Windows.Forms.ToolStripMenuItem();
            this.OpcSalir = new System.Windows.Forms.ToolStripMenuItem();
            this.editarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.compilarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.ayudaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.rtbEditor = new System.Windows.Forms.RichTextBox();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.archivoToolStripMenuItem,
            this.editarToolStripMenuItem,
            this.compilarToolStripMenuItem,
            this.ayudaToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(800, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // archivoToolStripMenuItem
            // 
            this.archivoToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.OpcNuevo,
            this.OpcAbrir,
            this.OpcGuardar,
            this.OpcGuardarComo,
            this.OpcSalir});
            this.archivoToolStripMenuItem.Name = "archivoToolStripMenuItem";
            this.archivoToolStripMenuItem.Size = new System.Drawing.Size(60, 20);
            this.archivoToolStripMenuItem.Text = "Archivo";
            // 
            // OpcNuevo
            // 
            this.OpcNuevo.Name = "OpcNuevo";
            this.OpcNuevo.Size = new System.Drawing.Size(150, 22);
            this.OpcNuevo.Text = "Nuevo";
            this.OpcNuevo.Click += new System.EventHandler(this.OpcNuevo_Click);
            // 
            // OpcAbrir
            // 
            this.OpcAbrir.Name = "OpcAbrir";
            this.OpcAbrir.Size = new System.Drawing.Size(150, 22);
            this.OpcAbrir.Text = "Abrir";
            this.OpcAbrir.Click += new System.EventHandler(this.OpcAbrir_Click);
            // 
            // OpcGuardar
            // 
            this.OpcGuardar.Name = "OpcGuardar";
            this.OpcGuardar.Size = new System.Drawing.Size(150, 22);
            this.OpcGuardar.Text = "Guardar";
            this.OpcGuardar.Click += new System.EventHandler(this.OpcGuardar_Click);
            // 
            // OpcGuardarComo
            // 
            this.OpcGuardarComo.Name = "OpcGuardarComo";
            this.OpcGuardarComo.Size = new System.Drawing.Size(150, 22);
            this.OpcGuardarComo.Text = "Guardar como";
            this.OpcGuardarComo.Click += new System.EventHandler(this.OpcGuardarComo_Click);
            // 
            // OpcSalir
            // 
            this.OpcSalir.Name = "OpcSalir";
            this.OpcSalir.Size = new System.Drawing.Size(150, 22);
            this.OpcSalir.Text = "Salir";
            this.OpcSalir.Click += new System.EventHandler(this.OpcSalir_Click);
            // 
            // editarToolStripMenuItem
            // 
            this.editarToolStripMenuItem.Name = "editarToolStripMenuItem";
            this.editarToolStripMenuItem.Size = new System.Drawing.Size(49, 20);
            this.editarToolStripMenuItem.Text = "Editar";
            // 
            // compilarToolStripMenuItem
            // 
            this.compilarToolStripMenuItem.Name = "compilarToolStripMenuItem";
            this.compilarToolStripMenuItem.Size = new System.Drawing.Size(68, 20);
            this.compilarToolStripMenuItem.Text = "Compilar";
            this.compilarToolStripMenuItem.Click += new System.EventHandler(this.compilarToolStripMenuItem_Click);
            // 
            // ayudaToolStripMenuItem
            // 
            this.ayudaToolStripMenuItem.Name = "ayudaToolStripMenuItem";
            this.ayudaToolStripMenuItem.Size = new System.Drawing.Size(53, 20);
            this.ayudaToolStripMenuItem.Text = "Ayuda";
            // 
            // rtbEditor
            // 
            this.rtbEditor.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.rtbEditor.Location = new System.Drawing.Point(0, 27);
            this.rtbEditor.Name = "rtbEditor";
            this.rtbEditor.Size = new System.Drawing.Size(800, 426);
            this.rtbEditor.TabIndex = 1;
            this.rtbEditor.Text = "";
            // 
            // frmEditor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.rtbEditor);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "frmEditor";
            this.Text = "MiniC";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem archivoToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem OpcNuevo;
        private System.Windows.Forms.ToolStripMenuItem OpcAbrir;
        private System.Windows.Forms.ToolStripMenuItem OpcGuardar;
        private System.Windows.Forms.ToolStripMenuItem OpcGuardarComo;
        private System.Windows.Forms.ToolStripMenuItem OpcSalir;
        private System.Windows.Forms.ToolStripMenuItem editarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem compilarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem ayudaToolStripMenuItem;
        private System.Windows.Forms.RichTextBox rtbEditor;
    }
}

