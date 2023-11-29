//Variaveis para a criação do poligono
  private float vpoligonoX1 = 10f;
    private float vpoligonoY1 = 40f;
    private float vpoligonoX2 = 25f;
    private float vpoligonoY2 = 40f;
    private float vpoligonoX3 = 25f;
    private float vpoligonoY3 = 10f;
    private float vpoligonoX4 = -25f;
    private float vpoligonoY4 = 10f;
    private float vpoligonoX5 = -25f;
    private float vpoligonoY5 = 40f;
    private float vpoligonoX6 = -10f;
    private float vpoligonoY6 = 40f;
    private float vpoligonoX7 = -10f;
    private float vpoligonoY7 = 60f;
    private float vpoligonoX8 = 10f;
    private float vpoligonoY8 = 60f;
    private float vpoligonoX9 = 10f;
    private float vpoligonoY9 = 40f;

public void inicializarVariaveis() {
      //Atribui um valor inicial para a variavel nivel
      nivel = 1;
    }

    //Cria o Poligono do Nivel 2
    private void poligonoNivel2(GL2 gl) {
        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex2f(vpoligonoX1, vpoligonoY1);
        gl.glVertex2f(vpoligonoX2, vpoligonoY2);
        gl.glVertex2f(vpoligonoX3, vpoligonoY3);
        gl.glVertex2f(vpoligonoX4, vpoligonoY4);
        gl.glVertex2f(vpoligonoX5, vpoligonoY5);
        gl.glVertex2f(vpoligonoX6, vpoligonoY6);
        gl.glVertex2f(vpoligonoX7, vpoligonoY7);
        gl.glVertex2f(vpoligonoX8, vpoligonoY8);
        gl.glVertex2f(vpoligonoX9, vpoligonoY9);
        gl.glEnd();
    }

    //Código da colisão do poligono do nivel 2
    private void colisaoPoligono(){
        if (centroEsferaY - raioY <= vpoligonoY1 && centroEsferaX - raioX+(raioX/3) <= vpoligonoX2 && centroEsferaX+ raioX-(raioX/3) >= vpoligonoX1 && centroEsferaY >= vpoligonoY1 ||
                centroEsferaY - raioY <= vpoligonoY5 && centroEsferaX - raioX+(raioX/3)<= vpoligonoX6 && centroEsferaX + raioX-(raioX/3)>= vpoligonoX5 && centroEsferaY >= vpoligonoY5 ||
                centroEsferaY - raioY  <= vpoligonoY7 && centroEsferaX - raioX+(raioX/3)<= vpoligonoX8 && centroEsferaX + raioX-(raioX/3)>= vpoligonoX7 && centroEsferaY >= vpoligonoY7) {
            centroEsferaY+= 0.5f;
            velocidadeY = -velocidadeY;
        }
        if (centroEsferaY <= vpoligonoY3 && centroEsferaX - raioX+(raioX/3)<= vpoligonoX3 && centroEsferaX+ raioX-(raioX/3)>= vpoligonoX4 && centroEsferaY + raioY >= vpoligonoY3) {
            centroEsferaY+= -0.5f;
            velocidadeY = -velocidadeY;
        }

        if (centroEsferaY - raioY + (raioX/3)<= vpoligonoY2 && centroEsferaX-raioX<= vpoligonoX2 && centroEsferaX >= vpoligonoX2 && centroEsferaY+ raioY-(raioX/3)>= vpoligonoY3 ||
                centroEsferaY- raioY+(raioX/3)<= vpoligonoY8 && centroEsferaX-raioX<= vpoligonoX8 && centroEsferaX >= vpoligonoX8 && centroEsferaY+ raioY-(raioX/3)>= vpoligonoY1) {
            centroEsferaX += 0.5f;
            velocidadeX = -velocidadeX;
        }
        if (centroEsferaY - raioY+(raioX/3)<= vpoligonoY5&& centroEsferaX <= vpoligonoX4 && centroEsferaX + raioX >= vpoligonoX4 && centroEsferaY+ raioY-(raioX/3)>= vpoligonoY4 ||
                centroEsferaY- raioY+(raioX/3)<= vpoligonoY7 && centroEsferaX <= vpoligonoX6 && centroEsferaX + raioX >= vpoligonoX6 && centroEsferaY+ raioY-(raioX/3)>= vpoligonoY6) {
            centroEsferaX += -0.5f;
            velocidadeX = -velocidadeX;
        }
    }

// Altera a velocidade da esfera e muda a variavel nivel para iniciar o nivel 2
private void iniciaFase2() {
        nivel = 2;
        velocidadeX = velocidadeX * 1.3f;
        velocidadeY = velocidadeY * 1.3f;
    }
  

@Override
public void display(GLAutoDrawable drawable) {
  if (sairTelaInicial) {
    // Muda a variável nível para iniciar o nível 2
          if (numPlacar == 200 && nivel == 1) {
              iniciaFase2();
          }
          // Inseri o Poligono e a colisão no nível 2
          if (nivel == 2) {
              gl.glColor3f(1,0,0);
              poligonoNivel2(gl);
              colisaoPoligono();
          }
  }
}
