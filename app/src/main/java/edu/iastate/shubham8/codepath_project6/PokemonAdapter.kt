import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.iastate.shubham8.codepath_project6.Pokemon
import edu.iastate.shubham8.codepath_project6.R

class PokemonAdapter(private val pokemonList: List<Pokemon>) :
    RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val typeTextView: TextView = itemView.findViewById(R.id.typeTextView)
        val imageView: ImageView = itemView.findViewById(R.id.pokemonImageView)

        init {
            // Add a click listener to the item view
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedPokemon = pokemonList[position]
                    // Show a toast message with the Pokemon's name
                    Toast.makeText(itemView.context, "Clicked: ${clickedPokemon.name}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentPokemon = pokemonList[position]
        holder.nameTextView.text = "Name: ${currentPokemon.name}"
        holder.typeTextView.text = "Type: ${currentPokemon.type}"
        Glide.with(holder.itemView.context).load(currentPokemon.imageUrl).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}