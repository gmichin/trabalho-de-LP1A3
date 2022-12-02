import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int totalFil = 5;
        int totalAss = 2;
        int totalVoo = 10;

        int x=0, y=0, z=0, assento=0, fileira=0, nro=0, i=0, j=0;
        String nome, cpf, modelo="", data="", hora="";
        
        Voo []voo = new Voo[totalVoo];

        while(((x>=0)||(y==3)||(z==4))&&(x!=3)){
            y=0;
            z=0;
            Aviao aviao = new Aviao(modelo, totalFil, totalAss);
            x = Integer.parseInt(JOptionPane.showInputDialog( "MENU PRINCIPAL\n\n1-Parâmetros do Sistema\n2-Reserva de Passagens\n3-Sair" ));

            if(x==1){
                while((y>=0)&&(y!=4)){
                    y = Integer.parseInt(JOptionPane.showInputDialog( "Parâmetros do Sistema\n\n1-Cadastrar Aeronave\n2-Cadastrar Voo\n3-Troca de Voo\n4-Voltar"));
                    switch(y){

                        case 1://cadastro da aeronave
                            nro = Integer.parseInt(JOptionPane.showInputDialog( "Digite o número do voo ("+totalVoo+" voo):"));
                            modelo = JOptionPane.showInputDialog( "Digite o modelo da aeronave:");
                            if(voo[nro-1]==null){
                                aviao = new Aviao(modelo, totalFil, totalAss);
                                voo[nro-1] = new Voo(aviao, nro, data, hora);
                            }else{
                                JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA", "Results", JOptionPane.WARNING_MESSAGE);                      
                            }
                            break;

                        case 2://cadastro do voo
                            nro = Integer.parseInt(JOptionPane.showInputDialog( "Digite o número do voo:"));
                            data = JOptionPane.showInputDialog( "Digite a data do voo(dd/mm/aa):");
                            hora = JOptionPane.showInputDialog( "Digite a hora do voo(hh:mm):");
                            voo[nro-1] = new Voo(aviao, nro, data, hora);
                            break;

                        case 3: //troca de voo 
                            String[] vooCadastrado = new String[totalVoo];
                            String vooCadas = "";
                            for(i=0;i<totalVoo;i++){
                                if(voo[i]!=null){
                                    vooCadastrado[i] =" ("+(i+1)+")";
                                }
                            }
                            for(j=0;j<totalVoo;j++){
                                if(voo[j]!=null){
                                    vooCadas = vooCadas + vooCadastrado[j];
                                }
                            }
                            nro = Integer.parseInt(JOptionPane.showInputDialog( "VOOS CADASTRADOS\n"+vooCadas+"\n\nDigite o número do voo ("+totalVoo+" voo):"));
                            break;    
                        
                        case 4: 
                            break;

                    default: 
                        JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA", "Results", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                }

            }else if(x==2){
                while((z>=0)&&(z!=4)){
                z = Integer.parseInt(JOptionPane.showInputDialog( "Reserva de passagens\n\n1-Fazer reserva\n2-Consultar lugares vazios\n3-Consultar reservas realizadas\n4-Voltar"));
                switch(z){

                        case 1://Fazer reserva
                            nome = JOptionPane.showInputDialog( "Digite o nome do passageiro:");
                            cpf = JOptionPane.showInputDialog( "Digite a cpf do passageiro:");
                            fileira = Integer.parseInt(JOptionPane.showInputDialog( "Digite a fileira que o passageiro deseja ficar ("+totalFil+" fileiras):"));
                            assento = Integer.parseInt(JOptionPane.showInputDialog( "Digite o assento que o passageiro deseja ficar("+totalAss+" assentos):"));
                            if(fileira>totalFil){
                                JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA: fileira", "Results", JOptionPane.WARNING_MESSAGE);
                            } else if(assento>totalAss){
                                JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA: fileira", "Results", JOptionPane.WARNING_MESSAGE);
                            }else{
                                Passageiro passageiro = new Passageiro(nome, cpf);
                                if(aviao.verificaLugarOcupado(fileira-1, assento-1)){
                                    JOptionPane.showMessageDialog(null, "LUGAR NÃO DISPONÍVEL", "Results", JOptionPane.ERROR_MESSAGE);
                                }
                                else{
                                    voo[nro-1].setAviao(fileira-1, assento-1, passageiro);
                                }
                            }
                            break;
                            
                        case 2: //Consultar lugares vazios
                            int ass1=0, fil1=0, ass2=0, fil2=0;
                            String assentosDisponiveis="";
                            String[][]assDisp = new String[totalFil][totalAss];
                            for(ass1=0;ass1<2;ass1++){
                                for(fil1=0;fil1<5;fil1++){
                                    if(voo[nro-1].verificaLugarOcupado(fil1, ass1)){
                                        assDisp[fil1][ass1] = null;
                                    } else {
                                        assDisp[fil1][ass1] = (fil1+1)+" - "+(ass1+1);
                                    }
                                }
                            }
                            for(fil2=0;fil2<5;fil2++){
                                for(ass2=0;ass2<2;ass2++){
                                    if(assDisp[fil2][ass2]!=null){
                                        assentosDisponiveis = assentosDisponiveis+"\n"+assDisp[fil2][ass2];
                                    }
                                }
                            }
                            JOptionPane.showMessageDialog(null, "LUGARES DISPONÍVEIS\n"+assentosDisponiveis, "Results", JOptionPane.PLAIN_MESSAGE);
                            break;

                        case 3: //Consultar reservas realizadas
                            int ass3=0, fil3=0, ass4=0, fil4=0;
                            String reservasRealizadas="";
                            String[][]resRea = new String[totalFil][totalAss];
                            for(ass3=0;ass3<2;ass3++){
                                for(fil3=0;fil3<5;fil3++){
                                    if(voo[nro-1].verificaLugarOcupado(fil3, ass3)){
                                        resRea[fil3][ass3] = (fil3+1)+" - "+(ass3+1)+": "+voo[nro-1].getPassageiro(fil3, ass3).getNome()+"("+voo[nro-1].getPassageiro(fil3, ass3).getCpf()+")";
                                    } else {
                                        resRea[fil3][ass3] = null;
                                    }   
                                }
                            }
                            for(ass4=0;ass4<2;ass4++){
                                for(fil4=0;fil4<5;fil4++){
                                    if(resRea[fil4][ass4]!=null){
                                        reservasRealizadas = reservasRealizadas+"\n"+resRea[fil4][ass4];
                                    }
                                }
                            }
                            JOptionPane.showMessageDialog(null, "RESERVAS REALIZADAS\nModelo do avião: "+aviao.modelo+"\nNúmero do voo: "+voo[nro-1].getNro()+"\nData e hora: "+voo[nro-1].getData()+"T"+voo[nro-1].getHora()+"\n"+reservasRealizadas, "Results", JOptionPane.PLAIN_MESSAGE);
                            break;

                        case 4: 
                            break;
                        default: 
                            JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA", "Results", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                    }
            } else if(x==3){
                break;
            }
            else{
                JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA", "Results", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
