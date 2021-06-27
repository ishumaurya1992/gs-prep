public class SkillInza {


   private static SkillInza skill  ;
   private SkillInza(){}


        static SkillInza getInstance(){
            if(skill==null)
                synchronized (SkillInza.class){
                    return new SkillInza();
                }


            return skill;
        }



}

