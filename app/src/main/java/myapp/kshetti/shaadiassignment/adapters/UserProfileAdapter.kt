package myapp.kshetti.shaadiassignment.adapters

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
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

                aboutTV.text = "'m 26 years outdated, 5’8″ tall, with a medium assemble and a constructive outlook within the course of life. I'm a Commerce Graduate from D.U. and at current figuring out totally different selections of pursuing my analysis further or discovering a job. According to my mom and father & mates, I'm a daring, self-made, down-to-earth specific particular person and I'm very energetic regarding taking up household duties. I like to decorate my residence with an entire stickler for hygiene. I'm searching for a Life Partner for me at  Milan Mantra using their beautiful biodata designs.";

                user = profile
                Glide.with(profileIV.context)
                    .load(profile.picture.large)
                    .into(profileIV)

                setAcceptanceView(profile.status)

                acceptIV.setOnClickListener {
                    profile.status = 1
                    function.invoke(profile)
                    setAcceptanceView(profile.status)
                }
                declineIV.setOnClickListener {
                    profile.status = -1
                    function.invoke(profile)
                    setAcceptanceView(profile.status)
                }
            }
        }

        private fun UserProfileRowBinding.setAcceptanceView(status: Int) {

            if (status != 0) {
                acceptIV.visibility = GONE
                declineIV.visibility = GONE
                acceptamceStatusTV.visibility = VISIBLE

                when (status) {
                    1 -> acceptamceStatusTV.text = "Accepted"
                    -1 -> acceptamceStatusTV.text = "Declined"
                }
            } else {
                acceptIV.visibility = VISIBLE
                declineIV.visibility = VISIBLE
                acceptamceStatusTV.visibility = GONE
            }
        }
    }

}