package me.zeroeightsix.kami.module.modules.experimental;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import me.zeroeightsix.kami.module.Module;

@Module.Info(
   name = "DeathExcuse",
   description = "Uhhhhh, you didn't die!",
   category = Module.Category.EXPERIMENTAL
)
public class DeathExcuse extends Module {
   private int delay = 0;

   public void onUpdate() {
      ++this.delay;
      List myList = Arrays.asList("C'mon bro! I'm on impact :(", "My mouse disconnected dude", "Stupid internet always really do be cutting out", "I'm getting DDoSed right now, that's why I died!", "Wow died because of my Ping", "BRB, ima go touch myself to Obama", "The cum on my fingers from my jerkfest earlier caused my fingers to slip off my mouse resulting in me dying", "ghostblock", "lag", "i was tabbed out", "I died thanks to ObamaHack!", "i only died because of ya'll being niggers and i couldn't take the blackness that surrounded me", "dude there was a man sneezing next to me", "my ethernet cable got disconnected", "your hacks were so OP!", "you were just lagging and teleporting around", "i died because of lag dude what the fuck is this server fuck off", "i died because i tripped on a rasin fml", "fucking lag", "good game buddy, let me play with both hands now", "oh, you killed me, next time i wont masturbate with both hands while fighting with you", "oh, you killed me, next time i wont play with my feet while fighting you", "i ate pork pls allah spare me", "i desynced", "fuck i got a ghost block", "my ping is really high", "i switched screens", "im  getting ddosed rn", "auto totem fail", "i accidentally did /kill", "my dog ate my mouse", "my gf wanted to sex me", "dude your ca is so fucking op stop it", "my dog ate my pc", "im lagging, i told you to stop", "my mom came into my room", "my dog pissed on my keyboard and my hand slipped", "my monitor ate my turtle so i had to turn it off to save him", "your mom squirted in my eye so i couldnt see", "the admin do /kill me", "absolute ping player", "i do be alive the server tped me why death message", "i was high on apple juice so died", "mE mOm cOmE aT mY rOoM aNd hE sAyEd i nEeDeD tO cOmE aWaY fRoM mE pC");
      Random r = new Random();
      int randomitem = r.nextInt(myList.size());
      String randomElement = (String)myList.get(randomitem);
      if (mc.player.isDead) {
         this.delay = 20000000;
      }

      if (this.delay > 20000100) {
         mc.player.sendChatMessage(randomElement);
         this.delay = 0;
      }

   }
}
