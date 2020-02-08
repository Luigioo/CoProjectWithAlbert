import java.util.*;

public class Main{


    public static void main(String args[]){
        
        int wwid = 1000;
        int hhig = 500;

        int rectWid = 20;
        int rectHig = 20;

        double runspeed = 0.3;

        boolean running = true;
        boolean spaceP = false;
        boolean leftP = false;
        boolean rightP = false;

        GameArena game = new GameArena(wwid, hhig);

        Brick[][] bricks = new Brick[25][50];

        game.setBricks(bricks);
        
        long lastTime = System.nanoTime();

        Pll player = new Pll(1, 1, "GREY");
        game.setPll(player);

        for(int i=0; i<25; i++){
            for(int j=0; j<50; j++){
                bricks[i][j] = new Brick((double)i, (double)j, "WHITE");
            }
        }
        for(Brick[] bAry : bricks){
            for (Brick b : bAry){
                if(b.ny >= 23) b.exist = true;
                if(b.nx >= 10 && b.nx <=15 && b.ny == 20) b.exist = true;
                if(b.nx == 21 && b.ny <= 21) b.exist = true;
            }
        }

        

        while(true){

            long nowTime = System.nanoTime();
            int deltaTime = ((int)(nowTime - lastTime))/1000000;
            lastTime = nowTime;

            //System.out.println(deltaTime);

            //take key input
            if(game.spacePressed()){
                if(!spaceP){
                    System.out.println("pressed");
                    player.setdy(-0.4);
                    player.sta = Cos.jump;
                    spaceP = true;
                }
            }else{
                spaceP = false;
            }

            if(game.rightPressed()){
                player.setdx(runspeed);
                rightP = true;
            }else{
                if(rightP){
                    //now right is just released
                    player.slowdown();
                }
                rightP = false;
            }

            if(game.leftPressed()){
                player.setdx(-runspeed);
                leftP = true;
            }else{
                if(leftP){
                    player.slowdown();
                }
                leftP = false;
            }

            //
            player.updataPos(deltaTime);
            player.applyg(deltaTime);

            //collision pos fix#
            int brkRow = Math.min(23, (int)player.getYPosition()/20);
            int brkColu = Math.min(48, (int)player.getXPosition()/20);
            switch (player.sta){
                case jump:
                    if(player.collide(bricks[brkRow][brkColu]) || player.collide(bricks[brkRow][brkColu+1])){
                        player.setYPosition((brkRow+1)*20);
                            
                    }
                    if(player.collide(bricks[brkRow+1][brkColu])){
                        player.setXPosition((brkColu+1)*20);
                    }
                    if(player.collide(bricks[brkRow+1][brkColu+1])){
                        player.setXPosition((brkColu)*20);
                    }
                    break;
                case fall:
                    if(player.collide(bricks[brkRow+1][brkColu]) || player.collide(bricks[brkRow+1][brkColu+1])){
                        player.setYPosition((brkRow+1)*20 - player.getHeight());
                        player.dy = 0;
                    }
                    if(player.collide(bricks[brkRow][brkColu])){
                        player.setXPosition((brkColu+1)*20);
                    }
                    if(player.collide(bricks[brkRow][brkColu+1])){
                        player.setXPosition((brkColu)*20);
                    }
                    break;
                case stand:
                    break;
                case run:
                    break;
                default:
                    break;
            }
            game.pause();


        }




    }
}