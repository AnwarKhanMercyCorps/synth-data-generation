const fs = require('fs');
["nav","header","footer"].map((x)=>{const d = fs.readFileSync("../resources/templates/fragments/"+x+'.html');fs.writeFileSync('src/app/shared/'+x+'.component.html', d);})
