package productions.darthplagueis.jsonparsinggridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import productions.darthplagueis.jsonparsinggridview.controller.DogBreedsAdapter;
import productions.darthplagueis.jsonparsinggridview.model.Message;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Message> dogBreedsList = getDogBreedsFromJson(buildDogBreedsObject());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new DogBreedsAdapter(dogBreedsList));
    }

    private List<Message> getDogBreedsFromJson(JSONObject object) {
        List<Message> dogBreedsList = new ArrayList<>();
        try {
            JSONArray jsonArray = object.getJSONArray("message");
            for (int i = 0; i < jsonArray.length(); i++) {
                Message message = new Message();
                String s = (String) jsonArray.get(i);
                message.setMessage(s);

                dogBreedsList.add(message);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dogBreedsList;
    }

    private JSONObject buildDogBreedsObject() {
        JSONObject dogs = null;
        String dogBreeds = "{\"status\":\"success\",\"message\":[\"affenpinscher\",\"african\",\"airedale\",\"akita\",\"appenzeller\",\"basenji\",\"beagle\",\"bluetick\",\"borzoi\",\"bouvier\",\"boxer\",\"brabancon\",\"briard\",\"bulldog\",\"bullterrier\",\"cairn\",\"chihuahua\",\"chow\",\"clumber\",\"collie\",\"coonhound\",\"corgi\",\"dachshund\",\"dane\",\"deerhound\",\"dhole\",\"dingo\",\"doberman\",\"elkhound\",\"entlebucher\",\"eskimo\",\"germanshepherd\",\"greyhound\",\"groenendael\",\"hound\",\"husky\",\"keeshond\",\"kelpie\",\"komondor\",\"kuvasz\",\"labrador\",\"leonberg\",\"lhasa\",\"malamute\",\"malinois\",\"maltese\",\"mastiff\",\"mexicanhairless\",\"mountain\",\"newfoundland\",\"otterhound\",\"papillon\",\"pekinese\",\"pembroke\",\"pinscher\",\"pointer\",\"pomeranian\",\"poodle\",\"pug\",\"pyrenees\",\"redbone\",\"retriever\",\"ridgeback\",\"rottweiler\",\"saluki\",\"samoyed\",\"schipperke\",\"schnauzer\",\"setter\",\"sheepdog\",\"shiba\",\"shihtzu\",\"spaniel\",\"springer\",\"stbernard\",\"terrier\",\"vizsla\",\"weimaraner\",\"whippet\",\"wolfhound\"]}";
        try {
            dogs = new JSONObject(dogBreeds);
            JSONArray dogsJSONArray = dogs.getJSONArray("message");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dogs;
    }
}
