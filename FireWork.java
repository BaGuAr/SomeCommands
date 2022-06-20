package tokyo.gmx.pvpcore.commands;

import org.bukkit.*; 
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.meta.FireworkMeta;
import tokyo.gmx.pvpcore.manager.managers.*;

import java.util.Random;

public class FireWork implements CommandExecutor {

    public Color[] colors = new Color[]{Color.AQUA, Color.BLACK, Color.BLUE, Color.FUCHSIA, Color.GRAY, Color.GREEN, Color.LIME, Color.MAROON, Color.NAVY, Color.OLIVE, Color.ORANGE, Color.PURPLE, Color.RED, Color.SILVER, Color.TEAL, Color.WHITE, Color.YELLOW};
    

    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
        if ( sender instanceof Player ){
            Player p = ((Player) sender).getPlayer();
            if( new RankManager().getAdminRanks().contains(new PlayerRankManager(new PlayerManager(p)).getTopRank()) ){ //This is our permission manager code. you can replace to sender.hasPermission etc
                for(int i=0;i<10;i++){ //10 time
                    firework(p);
                }
            }

        }
        return true;
    }

    public void firework(Player p){
        Random rand = new Random();
        int x = rand.nextInt(10) + 10;
        boolean a = rand.nextBoolean();
        boolean b = rand.nextBoolean();
        int z = rand.nextInt(10) + 10;
        int num1 = rand.nextInt(colors.length);
        int num2 = rand.nextInt(colors.length);
        Location l = p.getLocation().clone();
        if(a){
            l.setX(l.getX() - x);
        }else{
            l.setX(l.getX() + x);
        }
        if(b){
            l.setZ(l.getZ() - x);
        }else{
            l.setZ(l.getZ() + x);
        }
        Firework firework = (p.getWorld().spawn(l, Firework.class));
        FireworkMeta deta = firework.getFireworkMeta();
        deta.addEffects( FireworkEffect.builder().withColor(colors[num1]).withColor(colors[num2]).with(FireworkEffect.Type.BALL_LARGE).withFlicker().build());
        deta.setPower(2);
        firework.setFireworkMeta(deta);
        //firework to near location
    }
}
