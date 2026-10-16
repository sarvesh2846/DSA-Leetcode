//                   _____       _____
//      .........   {     }     {     }
//     (>>\zzzzzz [======================]
//     ( <<<\lllll_\\ _        _____    \\
//    _,`-,\<   __#:\\::_    __#:::_:__  \\
//   /    . `--,#::::\\:::___#::::/__+_\ _\\                 
//  /  _  .`-    `--,/_~~~~~~~~~~~~~~~~~~~~  -,_
// :,// \ .         .  '--,____________   ______`-,        
//  :: o |.         .  ___ \_____||____\◣◢/     ||~ \         
//  :;   ;-,_       . ,' _`,""""""""""""""""""""""""\
//  \ \_/ _ :`-,_   . ; / \\ ====================== /
//   \__/~ /     `-,.; ; o |\_[~~~]『ＴＨΛＲ』[~~~]__:
//      ~~~          ; :   ;~ ;  ~~~         ;~~~::;
//                    \ \_/ ~/               ::::::;
//                     \_/~~/                 \:::/  
//                       ~~~                   ~~~       -- Design By SΛRVΞSH
class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totGas = 0, totCost = 0;
        int start = 0, currGas = 0;

        for(int i = 0; i < gas.length; i++){
            totGas += gas[i];
            totCost += cost[i];

            currGas += (gas[i] - cost[i]); // CNG Mileage

            if(currGas < 0){
                start = i+1; // move to nxt station
                currGas = 0; // currGas will reinitialised
            }
            
        }

         // GNG Gas jada phije Cost peksha tr valid soln ahe otherwise return start val which is finded
        return totGas < totCost ? -1 : start;
    }
}