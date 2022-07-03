package ng.dominic.affirmative.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ng.dominic.affirmative.R
import ng.dominic.affirmative.model.Affirmation

/**
 *  Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
 */
class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    /**
     * The onCreateViewHolder()method is called by the layout manager to create new view holders for
     * the RecyclerView (when there are no existing view holders that can be reused). Remember that
     * a view holder represents a single list item view.
     *
     * The onCreateViewHolder() method takes two parameters and returns a new ViewHolder.
     * 1.   A parent parameter, which is the view group that the new list item view will be attached
     *      to as a child. The parent is the RecyclerView.
     * 2.   A viewType parameter which becomes important when there are multiple item view types in
     *      the same RecyclerView. If you have different list item layouts displayed within the
     *      RecyclerView, there are different item view types. You can only recycle views with the
     *      same item view type. In your case, there is only one list item layout and one item view
     *      type, so you don't have to worry about this parameter.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    override fun getItemCount(): Int = dataset.size
}