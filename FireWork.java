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
}
