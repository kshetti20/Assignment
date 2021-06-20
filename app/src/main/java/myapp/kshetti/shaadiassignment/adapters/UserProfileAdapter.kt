package myapp.kshetti.shaadiassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import myapp.kshetti.shaadiassignment.databinding.UserProfileRowBinding
import myapp.kshetti.trialapp.model.Results

class UserProfileAdapter(val results: List<Results>, val function: (Results) -> Unit) :
    RecyclerView.Adapter<UserProfileAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            UserProfileRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(results[position])
    }

    override fun getItemCount() = results.size


    inner class ViewHolder(val binding: UserProfileRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(profile: Results) {
            binding.apply {

            Glide.with(profileIV.context)
                .load(profile.picture.thumbnail)
                .into(profileIV)

                user = profile

                acceptIV.setOnClickListener {
                    profile.status = 1
                    function.invoke(profile)
                }
                declineIV.setOnClickListener {
                    profile.status = -1
                    function.invoke(profile)
                }
            }
        }
    }

}